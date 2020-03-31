package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import houwing.top.cake_site.biz.AccountBiz;
import houwing.top.cake_site.biz.CakeBiz;
import houwing.top.cake_site.biz.CatalogBiz;
import houwing.top.cake_site.biz.UserBiz;
import houwing.top.cake_site.biz.impl.AccountBizImpl;
import houwing.top.cake_site.biz.impl.CakeBizImpl;
import houwing.top.cake_site.biz.impl.CatalogBizImpl;
import houwing.top.cake_site.biz.impl.UserBizImpl;
import houwing.top.cake_site.entity.Account;
import houwing.top.cake_site.entity.Cake;
import houwing.top.cake_site.entity.Catalog;
import org.apache.log4j.Logger;
import sun.rmi.runtime.Log;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class DefaultController {
    Logger log= Logger.getLogger(DefaultController.class);
    private AccountBiz accountBiz=new AccountBizImpl();
    private CakeBiz cakeBiz=new CakeBizImpl();
    private UserBiz userBiz=new UserBizImpl();
    private CatalogBiz catalogBiz=new CatalogBizImpl();

    // /toLogin.do
    public void toLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/admin/login.jsp").forward(request,response);
    }
    // /login.do
    public void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("account");
        String password = request.getParameter("password");
        Account account = accountBiz.login(name, password);
        if(account==null){
            response.sendRedirect("/toLogin.do");
        }else {
            request.getSession().setAttribute("ACCOUNT",account);
            response.sendRedirect("/admin/Cake/list.do");
        }
    }
    // /quit.do
    public void quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

            request.getSession().setAttribute("ACCOUNT",null);
            response.sendRedirect("/toLogin.do");

    }

    // /index.do
    public void index(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /*
        * 1.特卖商品
        * 2.推荐商品
        * 3.分类
        * */
        List<Cake> special = cakeBiz.getSpecial();
        request.setAttribute("specialList",special);
        log.info("specialList: "+special);
        List<Cake> list = cakeBiz.getForIndex();
        request.setAttribute("list",list);

        request.getRequestDispatcher("/WEB-INF/pages/index.jsp").forward(request,response);
    }
    // /list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int cid=Integer.parseInt(request.getParameter("cid"));
        String pageNum=request.getParameter("pageNum");
        if(pageNum==null)
            pageNum="1";
        PageHelper.startPage(Integer.parseInt(pageNum),12);
        List<Cake> list = cakeBiz.getForCatalog(cid);
        PageInfo pageInfo=PageInfo.of(list);
        request.setAttribute("pageInfo",pageInfo);
        request.setAttribute("cid",cid);


        request.getRequestDispatcher("/WEB-INF/pages/list.jsp").forward(request,response);
    }
    // /detail.do
    public void detail(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id=Integer.parseInt(request.getParameter("id"));
        Cake cake = cakeBiz.get(id);
        request.setAttribute("cake",cake);
        request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(request,response);
    }
    // /toRegist.do
    public void toRegist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/regist.jsp").forward(request,response);
    }

    public void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String nickname = request.getParameter("nickname");
        int priotiry=0;
        Account account=new Account(username,userpass,nickname,priotiry);
        userBiz.insertUser(account);
        response.sendRedirect("/index.do");
    }
    // /login.do
    public void userLogin(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().setAttribute("ALART",null);
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        Account account=new Account();
        account.setUserpass(userpass);
        account.setUsername(username);
        Account USER = userBiz.selectByUsername(account);
        if (USER != null) {
            if (USER.getUsername() != null) {
                request.getSession().setAttribute("USER",USER);
            }else {
                request.getSession().setAttribute("ALART","admin or locking");
            }
        }
        response.sendRedirect("/index.do");
    }
    // /login.do
    public void userQuit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.getSession().setAttribute("USER", null);
        response.sendRedirect("/index.do");
    }

}

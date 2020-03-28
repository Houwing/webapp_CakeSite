package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import houwing.top.cake_site.biz.AccountBiz;
import houwing.top.cake_site.biz.impl.AccountBizImpl;
import houwing.top.cake_site.entity.Account;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AccountController {
    Logger log = Logger.getLogger(AccountController.class);
    private AccountBiz accountBiz=new AccountBizImpl();
    // /admin/Account/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pageNum=request.getParameter("pageNum");
        if(pageNum==null)
            pageNum="1";
        PageHelper.startPage(Integer.parseInt(pageNum),20);
        List<Account> list = accountBiz.getAllAdmin();
        PageInfo pageInfo=PageInfo.of(list);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/admin/account_list.jsp").forward(request,response);
    }
    // /admin/Account/toAdd.do
    public void toAdd(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/pages/admin/account_add.jsp").forward(request,response);
    }
    // /admin/Account/add.do
    public void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        int priority = 1;
        String nickname = request.getParameter("nickname");
//        log.info(username+userpass+nickname);
        Account account=new Account(username,userpass,nickname,priority);
//        log.info(account);
        accountBiz.insertAccount(account);
        response.sendRedirect("/admin/Account/list.do");
    }
    // /admin/Account/toEdit.do
    public void toEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Account account=accountBiz.selectById(Integer.parseInt(id));
        log.info(account);
        request.setAttribute("account",account);
        request.getRequestDispatcher("/WEB-INF/pages/admin/account_edit.jsp").forward(request,response);
    }
    // /admin/Account/edit.do
    public void edit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String userpass = request.getParameter("userpass");
        String nickname = request.getParameter("nickname");
        String id = request.getParameter("id");
        Account account=new Account();
        account.setId(Integer.parseInt(id));
        account.setUsername(username);
        account.setUserpass(userpass);
        account.setNickname(nickname);
//        log.info(account);
        accountBiz.updateAccount(account);
        response.sendRedirect("/admin/Account/list.do");
    }
    // /admin/Account/delete.do
    public void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");

//        log.info(account);
        accountBiz.deleteAccount(Integer.parseInt(id));
        response.sendRedirect("/admin/Account/list.do");
    }
}

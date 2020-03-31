package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import houwing.top.cake_site.biz.UserBiz;
import houwing.top.cake_site.biz.impl.UserBizImpl;
import houwing.top.cake_site.entity.Account;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class UserController {
    Logger log=Logger.getLogger(UserController.class);
    UserBiz userBiz=new UserBizImpl();
    // /admin/User/list.do
    public void list(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String pageNum = request.getParameter("pageNum");
        if (pageNum==null)
            pageNum="1";
        List<Account> list = userBiz.getAll();
        PageHelper.startPage(Integer.parseInt(pageNum),20);
        PageInfo pageInfo=PageInfo.of(list);
        request.setAttribute("pageInfo",pageInfo);
        log.info(list);
        request.getRequestDispatcher("/WEB-INF/pages/admin/user_list.jsp").forward(request,response);
    }
    // /admin/User/delete.do
    public void delete(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userBiz.deleteUser(Integer.parseInt(id));
        response.sendRedirect("/admin/User/list.do");
    }

    // /admin/User/lock.do
    public void lock(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userBiz.lockUser(Integer.parseInt(id));
        response.sendRedirect("/admin/User/list.do");
    }
    // /admin/User/lock.do
    public void unlock(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        userBiz.unlockUser(Integer.parseInt(id));
        response.sendRedirect("/admin/User/list.do");
    }
}

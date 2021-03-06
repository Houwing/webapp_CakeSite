package houwing.top.cake_site.global;

import houwing.top.cake_site.entity.Account;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginFilter implements Filter {
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("LoginFilter initing...");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse)resp;
        HttpServletRequest request=(HttpServletRequest)req;
        Object object= request.getSession().getAttribute("ACCOUNT");

        if(object==null){
//            object= new Account();
            response.sendRedirect("/toLogin.do");
//            chain.doFilter(request,response);
        }else {
            System.out.println("do filter");
            chain.doFilter(request,response);
        }

    }

    public void destroy() {
        System.out.println("LoginFilter destroying...");
    }
}

package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import houwing.top.cake_site.biz.CartBiz;
import houwing.top.cake_site.biz.impl.CartBizImpl;
import houwing.top.cake_site.entity.Cart;
import org.apache.log4j.Logger;
import org.apache.log4j.pattern.IntegerPatternConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CartController {

    CartBiz cartBiz=new CartBizImpl();
    Logger log=Logger.getLogger(CartController.class);

    // /my/Cart/addCart.do
    public void addCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.getSession().setAttribute("ALART",null );
        String userId = request.getParameter("userId");
        String cakeId = request.getParameter("cakeId");
        if (userId.length()==0) {
            response.sendRedirect("/index.do");
            request.getSession().setAttribute("ALART","Please sign in first");
        }
        Cart cart =new Cart(Integer.parseInt(userId),Integer.parseInt(cakeId),1);
        cartBiz.addCart(cart);
        request.getRequestDispatcher("/WEB-INF/pages/cart_success.jsp").forward(request,response);
    }

    // /my/Cart/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        int id = Integer.parseInt(request.getParameter("id"));
        String pageNum = request.getParameter("pageNum");
        if (pageNum==null)
            pageNum="1";
        PageHelper.startPage(Integer.parseInt(pageNum),6);
        List<Cart> carts = cartBiz.getCartsByUserId(id);
//        log.info(carts);
        PageInfo pageInfo=PageInfo.of(carts);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/cart.jsp").forward(request,response);
    }

    // /my/Cart/remove.do
    public void remove(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cartId = request.getParameter("cartId");
        Cart cart = cartBiz.select(Integer.parseInt(cartId));
        int userId = cart.getUserId();
        //        log.info(cartId+"-"+userId);
        cartBiz.deleteCart(Integer.parseInt(cartId));
        response.sendRedirect("/my/Cart/list.do?id="+userId);
    }

    // /my/Cart/plusCart.do
    public void plusCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cartId = request.getParameter("cartId");
        Cart cart = cartBiz.select(Integer.parseInt(cartId));
        int quantity = cart.getQuantity();
        quantity=quantity+1;
        cart.setQuantity(quantity);
        cartBiz.updateCart(cart);
        int userId = cart.getUserId();
        response.sendRedirect("/my/Cart/list.do?id="+userId);
    }
    // /my/Cart/minusCart.do
    public void minusCart(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String cartId = request.getParameter("cartId");
        Cart cart = cartBiz.select(Integer.parseInt(cartId));
        int quantity = cart.getQuantity();
        quantity=quantity-1;
        if(quantity==0){
            //删除产品
            cartBiz.deleteCart(cart.getId());
        }else {
            cart.setQuantity(quantity);
            cartBiz.updateCart(cart);
        }

        int userId = cart.getUserId();
        response.sendRedirect("/my/Cart/list.do?id="+userId);
    }
}

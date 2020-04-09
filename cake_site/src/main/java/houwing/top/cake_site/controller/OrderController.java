package houwing.top.cake_site.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import houwing.top.cake_site.biz.CakeBiz;
import houwing.top.cake_site.biz.CartBiz;
import houwing.top.cake_site.biz.OrderBiz;
import houwing.top.cake_site.biz.impl.CakeBizImpl;
import houwing.top.cake_site.biz.impl.CartBizImpl;
import houwing.top.cake_site.biz.impl.OrderBizImpl;
import houwing.top.cake_site.entity.Cake;
import houwing.top.cake_site.entity.Cart;
import houwing.top.cake_site.entity.Order;
import org.apache.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OrderController {

    Logger log=Logger.getLogger(OrderController.class);
    CartBiz cartBiz=new CartBizImpl();
    CakeBiz cakeBiz=new CakeBizImpl();
    OrderBiz orderBiz=new OrderBizImpl();

    // /my/Order/addOrder.do
    public void addOrder(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String[] cartids_str = request.getParameterValues("cartid");
        int userid = Integer.parseInt(request.getParameter("userid"));
        if(cartids_str==null){
            request.getSession().setAttribute("ALART","Please check on 1 item at least");
            response.sendRedirect("/my/Cart/list.do?id="+userid);
        }
        int[] cartids=new int[cartids_str.length];
        List<Cart> carts=new ArrayList<Cart>();
        Order order=new Order();
        double payment=0;
        //转换int类型
        int i=0;
        for (String str:cartids_str) {
            cartids[i]=Integer.parseInt(str);
            i++;
        }
        //获取购物车list
        for (int cartid:
             cartids) {
            Cart cart = cartBiz.select(cartid);
            log.info(cart);
            carts.add(cart);
        }
        // 删除购物车
        for (Cart cart:
             carts) {
            int cartid=cart.getId();
            int cakeid=cart.getCakeId();
            Cake cake = cakeBiz.get(cakeid);
            payment=payment+cart.getQuantity()*cake.getPrice();
            cartBiz.deleteCart(cartid);
        }
        //创建订单 插入订单
        order.setPayment(payment);
        order.setUser_id(userid);
        order.setPayment_type(1);
        order.setStatus(20);
        orderBiz.addOrder(order);
        //跳转
        request.getRequestDispatcher("/WEB-INF/pages/order_success.jsp").forward(request,response);
    }

    // /admin/Order/list.do
    public void list(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String pageNum = request.getParameter("pageNum");
        if (pageNum==null)
            pageNum="1";
        PageHelper.startPage(Integer.parseInt(pageNum),6);
        List<Order> list = orderBiz.getAll();
        PageInfo pageInfo=PageInfo.of(list);
        request.setAttribute("pageInfo",pageInfo);
        request.getRequestDispatcher("/WEB-INF/pages/admin/order_list.jsp").forward(request,response);
    }
}

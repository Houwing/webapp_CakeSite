package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Order;

import java.util.List;

public interface OrderBiz {

    void addOrder(Order order);

    List<Order> getAll();
}

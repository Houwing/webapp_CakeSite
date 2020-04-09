package houwing.top.cake_site.biz.impl;

import houwing.top.cake_site.biz.OrderBiz;
import houwing.top.cake_site.dao.OrderDao;
import houwing.top.cake_site.entity.Order;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class OrderBizImpl implements OrderBiz {
    OrderDao orderDao= DaoFactory.getInstance().getDao(OrderDao.class);
    public void addOrder(Order order) {
        orderDao.insert(order);
    }

    public List<Order> getAll() {
        return orderDao.getAll();
    }
}

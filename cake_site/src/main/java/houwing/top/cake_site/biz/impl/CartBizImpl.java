package houwing.top.cake_site.biz.impl;

import houwing.top.cake_site.biz.CartBiz;
import houwing.top.cake_site.dao.CakeDao;
import houwing.top.cake_site.dao.CartDao;
import houwing.top.cake_site.entity.Cart;
import houwing.top.cake_site.global.DaoFactory;

import java.util.List;

public class CartBizImpl implements CartBiz {
    CartDao cartDao= DaoFactory.getInstance().getDao(CartDao.class);
    CakeDao cakeDao=DaoFactory.getInstance().getDao(CakeDao.class);
    public void addCart(Cart cart) {
        cartDao.addCart(cart);
    }

    public void deleteCart(int id) {
        cartDao.delete(id);
    }

    public void updateCart(Cart cart) {
        cartDao.update(cart);
    }

    public List<Cart> getCartsByUserId(int user_id) {
        List<Cart> carts=cartDao.getAllByUserId(user_id);
        for (Cart cart:carts) {
            int cakeId = cart.getCakeId();
            cart.setCake(cakeDao.select(cakeId));
        }
        return carts;
    }

    public Cart select(int id) {
        return cartDao.select(id);
    }
}

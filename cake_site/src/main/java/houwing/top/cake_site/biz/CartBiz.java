package houwing.top.cake_site.biz;

import houwing.top.cake_site.entity.Cart;

import java.util.List;

public interface CartBiz {

    void addCart(Cart cart);
    void deleteCart(int id);
    void updateCart(Cart cart);
    List<Cart> getCartsByUserId(int user_id);
    Cart select(int id);
}

package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Cart;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CartDao {

    @Insert("insert into cart(userId,cakeId,quantity,create_time,update_time)values(#{userId},#{cakeId},#{quantity},now(),now())")
    void addCart(Cart cart);

    @Select("select * from cart where userId=#{id}")
    @Results(id = "cart", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "userId",property = "userId"),
            @Result(column = "cakeId",property = "cakeId"),
            @Result(column = "quantity",property = "quantity"),
            @Result(column = "create_time",property = "create_time"),
            @Result(column = "update_time",property = "update_time")
    })
    List<Cart> getAllByUserId(int id);

    @Delete("delete from cart where id=#{id}")
    void delete(int id);

    @Update("update cart set quantity=#{quantity},update_time=now() where id=#{id}")
    void update(Cart cart);

    @Select("select * from cart where id=#{id}")
    Cart select(int id);
}

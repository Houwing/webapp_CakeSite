package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDao {

    @Insert("insert into tbl_order(user_id,payment,payment_type,status,payment_time,create_time,update_time)values(#{user_id},#{payment},#{payment_type},#{status},now(),now(),now())")
    void insert(Order order);

    @Select("select * from tbl_order")
    @Results(id = "order", value = {
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "user_id",column = "user_id"),
            @Result(property = "payment",column = "payment"),
            @Result(property = "payment_type",column = "payment_type"),
            @Result(property = "status",column = "status"),
            @Result(property = "payment_time",column = "payment_time"),
            @Result(property = "create_time",column = "create_time"),
            @Result(property = "update_time",column = "update_time")
    })
    List<Order> getAll();
}

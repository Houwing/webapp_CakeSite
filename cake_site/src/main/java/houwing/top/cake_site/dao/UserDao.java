package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserDao {

    @Select("select * from user where priority=0")
    @Results(id = "user", value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "username",property = "username"),
            @Result(column = "userpass",property = "userpass"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "priority",property = "priority"),
            @Result(column = "islock",property = "lock")
    })
    List<Account> getAll();

    @Delete("delete from user where id=#{id}")
    void delete(int id);

    @Update("update user set islock=true where id=#{id}")
    void lock(int id);

    @Update("update user set islock=false where id=#{id}")
    void unlock(int id);

    @Insert("insert into user(username,userpass,nickname,priority) values(#{username},#{userpass},#{nickname},#{priority})")
    void insert(Account account);
}

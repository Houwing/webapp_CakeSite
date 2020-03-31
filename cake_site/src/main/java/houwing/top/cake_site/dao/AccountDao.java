package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Account;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface AccountDao {

    @Select("select * from user where username=#{name}")
    @Results(id = "user", value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "username",property = "username"),
            @Result(column = "userpass",property = "userpass"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "priority",property = "priority"),
            @Result(column = "islock",property = "lock")
    })
    List<Account> selectByName(String name);

    @Select("select * from user where priority=1")
    @ResultMap("user")
    List<Account> getAllAdmin();

    @Insert("insert into user(username,userpass,nickname,priority)values(#{username},#{userpass},#{nickname},#{priority})")
    void insertAccount(Account account);

    @Select("select * from user where id=#{id}")
    @ResultMap("user")
    Account selectById(int id);

    @Update("update user set username=#{username},userpass=#{userpass},nickname=#{nickname} where id=#{id}")
    void updateAccount(Account account);

    @Delete("delete from user where id=#{id}")
    void deleteAccount(int id);
}

package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Account;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AccountDao {

    @Select("select * from user where username=#{name}")
    @Results(id = "user", value = {
            @Result(column = "id",property = "id",id = true),
            @Result(column = "username",property = "username"),
            @Result(column = "userpass",property = "userpass"),
            @Result(column = "nickname",property = "nickname"),
            @Result(column = "priority",property = "priority")
    })
    List<Account> selectByName(String name);
}

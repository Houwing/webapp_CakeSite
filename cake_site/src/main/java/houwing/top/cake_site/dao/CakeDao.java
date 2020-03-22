package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Cake;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CakeDao {
    @Insert("insert into cake(cakename, category, image, price, brand, taste, sweet, weight, size, ingredients, status)values(#{cakename}, #{category}, #{image}, #{price}, #{brand}, #{taste}, #{sweet}, #{weight}, #{size}, #{ingredients}, #{status})")
    void insert(Cake cake);


    @Update("update cake set cakename=#{cakename}, category=#{category}, image=#{image}, price=#{price}, brand=#{brand}, taste=#{taste}," +
            " sweet=#{sweet}, weight=#{weight}, size=#{size}, ingredients=#{ingredients}, status=#{status} where id=#{id}")
    void update(Cake cake);


    @Delete("delete from cake where id=#{id}")
    void delete(int id);


    @Select("select c.*, ca.name cname from " +
            "cake c left join categories ca" +
            " on c.category=ca.id" +
            " where c.id=#{id}")
    @Results(id = "all", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "cakename",property = "cakename"),
            @Result(column = "category", property = "category"),
            @Result(column = "price",property = "price"),
            @Result(column = "image",property = "image"),
            @Result(column = "brand",property = "brand"),
            @Result(column = "taste",property = "taste"),
            @Result(column = "sweet",property = "sweet"),
            @Result(column = "weight",property = "weight"),
            @Result(column = "size",property = "size"),
            @Result(column = "ingredients",property = "ingredients"),
            @Result(column = "status",property = "status"),
            @Result(column = "cname",property = "catalog.name")
    })
    Cake select(int id);


    @Select("select c.*, ca.name cname from " +
            "cake c left join categories ca" +
            " on c.category=ca.id" +
            " order by id desc")
    @ResultMap("all")
    List<Cake> selectAll();

    @Select("select c.*, ca.name cname from " +
            "cake c left join categories ca" +
            " on c.category=ca.id" +
            " where c.status=#{status}")
    @ResultMap("all")
    List<Cake> selectByStatus(String status);

    @Select("select c.*, ca.name cname from " +
            "cake c left join categories ca" +
            " on c.category=ca.id" +
            " where c.category=#{id}")
    @ResultMap("all")
    List<Cake> selectByCatalog(int id);


}

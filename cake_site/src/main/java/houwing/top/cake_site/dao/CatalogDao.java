package houwing.top.cake_site.dao;

import houwing.top.cake_site.entity.Catalog;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CatalogDao {

    @Insert("<script>" +
            "insert into categories(name,parent,description)values" +
            "<foreach collection='list' item='categrory' separator=','>" +
            "(#{categrory.name},#{categrory.parent},#{categrory.description})" +
            "</foreach>" +
            "</script>")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void batchInsert(List<Catalog> list);

    @Delete("delete from categories where id=#{id}")
    void delete(int id);

    @Select("select * from categories where id=#{id}")
    @Results(id = "all",value = {
            @Result(column = "id",property = "id", id = true),
            @Result(column = "name",property = "name"),
            @Result(column = "parent",property = "parent"),
            @Result(column = "description",property = "description"),
            @Result(column = "id",property = "children", many = @Many(select = "selectByParentId"))
    })
    Catalog select(int id);

    @Select("select * from categories where parent=#{parentId}")
    @ResultMap("all")
    List<Catalog> selectByParentId(int parentId);
}

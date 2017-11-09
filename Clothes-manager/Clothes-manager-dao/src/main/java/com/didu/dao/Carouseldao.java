package com.didu.dao;


import com.didu.domain.Carousel;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/26.
 */
public interface Carouseldao {
       //添加图片
    @Insert("insert into carousel(name,url) values(#{name},#{url})")
    /*@Options(keyProperty="id",useGeneratedKeys=true)*/
    int save(Carousel carousel);

    //批量查找图片
    @Select("select * from carousel")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "url", column = "url"),
    })
    List<Carousel> query();

    //删除图片
    @Delete("delete from carousel where id=#{id}")
    int removeImage(int id);

    //查看单张图片
    @Select("select * from carousel where id=#{id}")
    Carousel queryI(int id);

    //修改图片
    @Update("update carousel set name=#{name},url=#{url} where id=#{id}")
    boolean updateImage(Carousel carousel);
}

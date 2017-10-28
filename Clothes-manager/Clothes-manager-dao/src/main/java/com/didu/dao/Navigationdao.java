package com.didu.dao;

import com.didu.domain.Navigation;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface Navigationdao {
    //添加图片
    @Insert("insert into navigation(name,url,text) values(#{name},#{url},#{text})")
    int addImage(Navigation navigation);
    //查看单张图片
    @Select("select * from navigation where id=#{id}")
    Navigation queryI(int id);
    //修改图片
    @Update("update navigation set name=#{name},url=#{url},text=#{text} where id = #{id}")
    int updateImage(Navigation navigation);
    //查看所有图片
    @Select("select * from navigation")
    List<Navigation> query();
}

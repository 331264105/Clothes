package com.didu.dao;

import com.didu.domain.Hypermarket;
import com.didu.domain.Navigation;
import com.didu.sql.HypermarketSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/27.
 */
public interface Hypermarketdao {
    //添加专场
    @Insert("insert into hypermarket(url,title,time,location,describ,price,grade,remark,pai,property,classify) values (#{url},#{title},#{time},#{location},#{describ},#{price},#{grade},#{remark},#{pai},#{property},#{classify})")
    int addHypermarket(Hypermarket hypermarket);
    //查询单个专场
    @Select("select * from hypermarket where id = #{id}")
    Hypermarket queryI(int id);
    //删除专场
    @Delete("delete from hypermarket where id=#{id}")
    int removeHypermarket(int id);
    //动态查看专场
    @SelectProvider(type = HypermarketSql.class,method = "selectHypermarket")
    @Results({
            @Result(id=true,property="id",column="id"),
            @Result(property="title",column="title"),
            @Result(property="url",column="url"),
            @Result(property="time",column="time"),
            @Result(property="location",column="location"),
            @Result(property="describ",column="describ"),
            @Result(property="price",column="price"),
            @Result(property="grade",column="grade"),
            @Result(property="remark",column="remark"),
            @Result(property="pai",column="pai"),
            @Result(property="property",column="property"),
    })
    List<Hypermarket> query(String property);
    //修改专场
    @Update("update hypermarket set url=#{url},title=#{title},time=#{time},location=#{location},describ=#{describ},price=#{price},grade=#{grade},remark=#{remark},pai=#{pai} where id=#{id}")
    int updateHypermarket(Hypermarket hypermarket);


}

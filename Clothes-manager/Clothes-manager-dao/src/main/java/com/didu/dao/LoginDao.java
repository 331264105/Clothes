package com.didu.dao;

import com.didu.domain.User;
import com.didu.sql.UserSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */
public interface LoginDao {
        @Select("select * from user where userphone=#{userphone} and password=#{password} and status=#{status}")
        @Results({
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "userphone", column = "userphone"),
                @Result(property = "password", column = "password"),
                @Result(property = "status", column = "status"),
                @Result(property = "balance", column = "balance"),
        })
        User login(User admin);
        @Insert("insert into user (password,userphone,openid,member,balance) values(#{password},#{userphone},#{openid},#{member},#{balance})")
        int register(User user);
        @Insert("insert into user (password,userphone,status) values(#{password},#{userphone},#{status})")
        int registerAdmin(User user);
        @UpdateProvider(type = UserSql.class,method ="updateUser")
        int updateUser(User user);
        @Select("select * from user")
        List<User> queryUser();
        @Select("select id from user where openid=#{openid}")
        int queryIdByOpenid(String openid);
        @SelectProvider(type = UserSql.class,method ="queryUserByStatus")
        List<User> queryUserByStatus(String status,String member);
        @Select("select * from user where userphone=#{userphone}")
        User checkUser(User user);
        @Select("select * from user where openid=#{openid}")
        @Results({
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "userphone", column = "userphone"),
                @Result(property = "password", column = "password"),
                @Result(property = "status", column = "status"),
                @Result(property = "balance", column = "balance"),
        })
        User userlogin(User admin);
        @SelectProvider(type = UserSql.class,method ="lookUser")
        User lookUserByPho(String phone,String openid);
}

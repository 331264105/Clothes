package com.didu.dao;

import com.didu.domain.User;
import com.didu.sql.UserSql;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */
public interface LoginDao {
        @Select("select * from user where username=#{username} and password=#{password} and status=#{status}")
        @Results({
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "username", column = "username"),
                @Result(property = "userphone", column = "userphone"),
                @Result(property = "password", column = "password"),
                @Result(property = "status", column = "status"),
                @Result(property = "balance", column = "balance"),
        })
        User login(User admin);
        @Insert("insert into user (username,password,userphone,openid) values(#{username},#{password},#{userphone},#{openid})")
        int register(User user);
        @UpdateProvider(type = UserSql.class,method ="updateUser")
        int updateUser(User user);
        @Select("select * from user")
        List<User> queryUser();
        @Select("select id from user where openid=#{openid}")
        int queryIdByOpenid(String openid);

}

package com.didu.dao;

import com.didu.domain.User;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

/**
 * Created by Administrator on 2017/10/28.
 */
public interface LoginDao {
        @Select("select * from user where username=#{username} and password=#{password} and status=#{status}")
        @Results({
                @Result(id = true, property = "id", column = "id"),
                @Result(property = "username", column = "username"),
                @Result(property = "password", column = "password"),
                @Result(property = "status", column = "status"),
        })
        User login(User admin);


}

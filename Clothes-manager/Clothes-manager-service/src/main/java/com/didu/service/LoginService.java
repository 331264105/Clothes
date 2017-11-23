package com.didu.service;

import com.didu.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */

public interface LoginService {
    User login(User user);
    boolean register(User user);
    boolean updateUser(User user);
    List<User> queryUser();
    int queryIdByOpenid(String openid);
    List<User> queryUserByStatus(String status,String memeber);
    User checkUser(User user);
    User userlogin(User user);
    boolean registerAdmin(User user);
    User lookUserByPho(String phone,String openid);
    boolean updatePassByphone(User user);
    boolean updateTotalSpend(User user);
}

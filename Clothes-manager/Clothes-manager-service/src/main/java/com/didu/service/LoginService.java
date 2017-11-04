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
}

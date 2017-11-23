package com.didu.serviceImpl;

import com.didu.dao.LoginDao;
import com.didu.domain.User;
import com.didu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */
@Service
@Transactional
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao loginDao;
    @Override
    public User login(User user) {
        return loginDao.login(user);
    }

    @Override
    public boolean register(User user) {
        return loginDao.register(user)>0?true:false;
    }

    @Override
    public boolean updateUser(User user) {
        int a = loginDao.updateUser(user);
        return a>0?true:false;
    }

    @Override
    public List<User> queryUser() {
        return loginDao.queryUser();
    }

    @Override
    public int queryIdByOpenid(String openid) {
        int i = loginDao.queryIdByOpenid(openid);
        return i;
    }

    @Override
    public List<User> queryUserByStatus(String status, String member) {
        return loginDao.queryUserByStatus(status,member);
    }

    @Override
    public User checkUser(User user) {
        return loginDao.checkUser(user);
    }

    @Override
    public User userlogin(User user) {
        return loginDao.userlogin(user);
    }

    @Override
    public boolean registerAdmin(User user) {
        return loginDao.registerAdmin(user)>0?true:false;
    }

    @Override
    public User lookUserByPho(String phone,String openid) {
        return loginDao.lookUserByPho(phone,openid);
    }

    @Override
    public boolean updatePassByphone(User user) {
        return loginDao.updatePassByphone(user)>0?true:false;
    }

    @Override
    public boolean updateTotalSpend(User user) {
        return loginDao.updateTotalSpend(user)>0?true:false;
    }
}

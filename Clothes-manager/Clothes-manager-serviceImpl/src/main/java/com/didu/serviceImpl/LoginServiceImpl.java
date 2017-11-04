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
        System.out.println(a);
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
}

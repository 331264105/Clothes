package com.didu.web;

import com.didu.domain.User;
import com.didu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Administrator on 2017/10/28.
 */
@Controller
public class LoginControl {
    @Autowired
    private LoginService adminService;
    //管理员登陆
    @RequestMapping("/login")
    @ResponseBody
    public String login(User admin,HttpServletRequest request){
        User u= adminService.login(admin);
        if (u==null){
            return "false";
        }else{
            if((u.getUserphone()).equals(admin.getUserphone())&&(u.getPassword()).equals(admin.getPassword())&&(u.getStatus().equals(admin.getStatus()))){
                return "true";
            }else{
                return "false";
            }
        }
    }
    @RequestMapping("/registerAdmin")
    @ResponseBody
    public String registerAdmin(User user){
        User user1 = adminService.checkUser(user);
        if (user1==null){
            boolean s = adminService.registerAdmin(user);
            if (s){
                return  "true";
            }
            return "false";
        }else{
            return "false";
        }
    }
    //用户登陆
    @RequestMapping("/userlogin")
    @ResponseBody
    public String login(User admin){
        User u= adminService.userlogin(admin);
        System.out.println(u);
        System.out.println(admin+"111111"+admin.getPassword()+admin.getUserphone());
        if (admin.getUserphone().equals(u.getUserphone())&&admin.getPassword().equals(u.getPassword())){;
            return "true";
        }else{
           return "false";
        }
    }
    @RequestMapping("/register")
    @ResponseBody
    public String register(User user){
        User user1 = adminService.checkUser(user);
        if (user1==null){
            user.setMember("1");
            user.setBalance(0.00);
            boolean s = adminService.register(user);
            if (s){
                return  "true";
            }
            return "false";
        }else{
            return "false";
        }
    }
    @RequestMapping("/updateUser")
    @ResponseBody
    public String updateUser(User user){
        System.out.println(user);
        boolean b =adminService.updateUser(user);
        if (b){
            return "true";
        }
        return "false";
    }
    @RequestMapping("/queryUser")
    @ResponseBody
    public List<User> queryUser(){
        return adminService.queryUser();
    }
    //后台产看用户管理员
    @RequestMapping("/queryUserByStatus")
    @ResponseBody
    public List<User> queryUserByStatus(String status,String member) {
        return adminService.queryUserByStatus(status, member);
    }
    //通过手机和openid查看用户
    @RequestMapping("/queryUserByPhoOpe")
    @ResponseBody
    public User queryUserByPhoOpe(String phone,String openid){
        return adminService.lookUserByPho(phone,openid);
    }
}
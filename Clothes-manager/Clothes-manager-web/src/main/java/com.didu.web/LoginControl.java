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
    //注册
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
    public HashMap<String,Object> login(User admin){
        HashMap<String,Object> map = new HashMap<>();
        User u= adminService.userlogin(admin);
        if (u==null){
            map.put("success","false");
            map.put("msg","1");
            return map;
        }else{
            if (admin.getUserphone().equals(u.getUserphone())&&admin.getPassword().equals(u.getPassword())){
                map.put("success","true");
                map.put("msg",u);
                return map;
            }else{
                map.put("success","false");
                map.put("msg","2");
                return map;
            }
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
    //用户更改密码
    @RequestMapping("/updatePassByphone")
    @ResponseBody
    public String updatePassByphone(User user){
        boolean b = adminService.updatePassByphone(user);
        if (b){
            return "true";
        }else{
            return "false";
        }
    }
    //添加用户总消费以及更改余额
    @RequestMapping("/updateTotalSpend")
    @ResponseBody
    public String updateTotalSpend(User user,String userphone,String openid) {
        User user1 = adminService.lookUserByPho(userphone,openid);
        double totalspend = user1.getTotalspend();
        double v = totalspend + user.getTotalspend();
        user.setTotalspend(v);
        boolean b = adminService.updateTotalSpend(user);
        if (b) {
            return "true";
        } else {
            return "false";
        }
    }
}
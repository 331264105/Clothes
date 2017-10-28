package com.didu.web;

import com.didu.domain.User;
import com.didu.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2017/10/28.
 */
@Controller
@Scope("prototype")
public class LoginControl {
    @Autowired
    private LoginService adminService;
    @RequestMapping("/login")
    @ResponseBody
    public String login(User admin,HttpServletRequest request){
        User u= adminService.login(admin);
        if (u==null){
            return "false";
        }else{
            if((u.getUsername()).equals(admin.getUsername())&&(u.getPassword()).equals(admin.getPassword())){
                request.setAttribute("user",u);
                return "true";
            }else{
                return "false";
            }
        }
    }


}
package com.controller;

import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 登陆控制
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
@Controller
public class LoginController {
    @RequestMapping("login")
    public String login(String username,String password,String remeberme){
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        if(!StringUtils.isEmpty(remeberme)){
            token.setRememberMe(true);
        }
        Subject subject =  SecurityUtils.getSubject();
        try {
            subject.login(token);
            return "index";
        } catch (AuthenticationException e) {
            e.printStackTrace();
            return "redirect:/login.jsp";
        }
    }
}

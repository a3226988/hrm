package com.commons;

import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.Logger;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDateTime;

/**
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
@Component
@Log4j
public class MyException implements HandlerExceptionResolver {
    /*Logger log = Logger.getLogger(MyException.class);*/
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ex.printStackTrace();
        LocalDateTime now = LocalDateTime.now();
        log.error("【"+now+"】:程序出现错误！在【"+handler+"】出现异常，异常信息为：【"+ex.getMessage()+"】");
        ModelAndView mv = new ModelAndView();
        if(ex instanceof UnauthorizedException){
            mv.setViewName("redirect:/unauthorized.jsp");
        }else if(ex instanceof AuthorizationException){
            mv.setViewName("redirect:/login.jsp");
        }else{
            mv.setViewName("redirect:/error.jsp");
        }
        return mv;
    }
}

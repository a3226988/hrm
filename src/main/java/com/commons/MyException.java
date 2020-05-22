package com.commons;

import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Create by gc on 2020/5/21
 * 铁甲依然在
 */
@Component
public class MyException implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {

        ex.printStackTrace();
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

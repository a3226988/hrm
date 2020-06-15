package com.commons;

import lombok.extern.log4j.Log4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 控制层的日志拦截器
 * Create by gc on 2020/6/4
 * 铁甲依然在
 */
@Log4j
public class LogInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("客户端发送了【"+request.getRequestURL()+"】请求，传递的请求参数为：【"+request.getParameterMap()+"】,映射的controlelr方法为：【"+handler+"】");
        return true;
    }

}

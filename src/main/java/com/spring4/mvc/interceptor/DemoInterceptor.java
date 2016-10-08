package com.spring4.mvc.interceptor;/**
 * Created by user on 16/10/6.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * interceptor
 *
 * @author user
 * @create 2016 -10-06 上午11:34
 */

public class DemoInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        long startTime= System.currentTimeMillis();

        request.setAttribute("startTime",startTime);

        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        long startTime= (Long) request.getAttribute("startTime");

        request.removeAttribute("startTime");

        long endTime=System.currentTimeMillis();

        System.out.println("本次请求处理时间为： "+new Long(endTime-startTime)+"ms");


        request.setAttribute("handlerTime",endTime-startTime);
    }




}

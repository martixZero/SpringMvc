package com.spring4.mvc;/**
 * Created by user on 16/10/4.
 */

import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletRegistration.Dynamic;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * WebApplicationInitializer
 *
 * @author user
 * @create 2016 -10-04 下午8:45
 */

public class WebInitializer implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        AnnotationConfigWebApplicationContext context=new AnnotationConfigWebApplicationContext();

        //注册配置类
        context.register(MvcConfig.class);

        //设置context
        context.setServletContext(servletContext);

        Dynamic servlet=servletContext.addServlet("dispatcher",new DispatcherServlet(context));

//地址匹配
        servlet.addMapping("/");
        //启动顺序
        servlet.setLoadOnStartup(1);



    }
}

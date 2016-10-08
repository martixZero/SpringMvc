package com.spring4.mvc;

/**
 * Created by user on 16/10/4.
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

/**
 * config
 *
 * @author user
 * @create 2016 -10-04 下午8:37
 */

//相当于配置web.xml
//@Configuration
//@EnableWebMvc
//@ComponentScan("com.spring4.mvc")
public class MyMVCConfig {

    //注入bean
    /*@Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();

        //设置前缀
        viewResolver.setPrefix("/WEB-INF/classes/views/");

        //设置后缀
        viewResolver.setSuffix(".jsp");

        //设置试图解析类
        viewResolver.setViewClass(JstlView.class);

        //返回试图
        return viewResolver;
    }*/
}

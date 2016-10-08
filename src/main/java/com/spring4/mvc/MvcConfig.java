package com.spring4.mvc;


/**
 * Created by user on 16/10/6.
 */

import com.spring4.mvc.messageconventer.MyMessageConventer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import com.spring4.mvc.interceptor.DemoInterceptor;

import java.util.List;

/**
 * @author user
 * @create 2016 -10-06 上午11:25
 */
@Configuration
@ComponentScan("com.spring4.mvc")
@EnableWebMvc
public class MvcConfig extends WebMvcConfigurerAdapter {



    @Bean
    public InternalResourceViewResolver viewResolver(){
        InternalResourceViewResolver viewResolver=new InternalResourceViewResolver();

        viewResolver.setPrefix("/WEB-INF/classes/views/");

        viewResolver.setSuffix(".jsp");

        //使用的jstl  所以只能用jsp

        viewResolver.setViewClass(JstlView.class);

        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
    }

    @Bean
    public DemoInterceptor demoInterceptor(){
        return new DemoInterceptor();
    }


    //不忽略.后面的参数
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer){
        configurer.setUseSuffixPatternMatch(false);
    }


    //增加一个过滤器
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(demoInterceptor());
    }

    //添加视图控制器
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/index").setViewName("/index");


        registry.addViewController("/conventor").setViewName("/conventer");

        registry.addViewController("/toUpload").setViewName("upload");
    }


    //配置自定义的HttpMessageConventor
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {


        converters.add(conventer());
    }

    public HttpMessageConverter conventer(){
        return new MyMessageConventer();

    }
    @Bean
    public MultipartResolver multipartResolver(){
        CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver();

        multipartResolver.setMaxUploadSize(1000000);

        return multipartResolver;
    }
}

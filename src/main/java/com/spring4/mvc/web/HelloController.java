package com.spring4.mvc.web;/**
 * Created by user on 16/10/4.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * hellocontroller
 *
 * @author user
 * @create 2016 -10-04 下午9:25
 */
@Controller
public class HelloController {
    @RequestMapping("/index")
    private String hello(){
        return "index";
    }
}

package com.spring4.mvc.web.ch4;/**
 * Created by user on 16/10/6.
 */

import com.spring4.mvc.domain.DemoObj;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * advice controller
 *
 * @author user
 * @create 2016 -10-06 下午1:11
 */
@Controller
public class AdviceController {

    @RequestMapping("/advice")
    public String getSomething(@ModelAttribute("msg") String msg, DemoObj obj){
        throw new IllegalArgumentException("sorry,the arguments is wrong/ "+"from @ModelAttribute:"+msg);
    }
}

package com.spring4.mvc.domain;/**
 * Created by user on 16/10/4.
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * @author user
 * @create 2016 -10-04 下午9:54
 */
@Controller
@RequestMapping("/anno")

public class DemoAnnoController {

    //返回值类型 produces  返回值会存在responseBody里
    @RequestMapping(produces = "text/plain;charset=UTF-8")
    public @ResponseBody String index(HttpServletRequest request){
        return "url: "+request.getRequestURL()+" can access";
    }

    @RequestMapping(value="/pathvar/{str}",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String DemoPathVar(@PathVariable String str,HttpServletRequest request){
        return "url: "+request.getRequestURL()+" can access,str ="+str;
    }

    @RequestMapping(value="/requestParam",produces = "text/plain;charset=UTF-8")
    public @ResponseBody String passRequestParam(Long id,HttpServletRequest request){
        return "url: "+request.getRequestURL()+" can access,id ="+id;

    }
    @RequestMapping(value = "/obj",produces = "application/json;charset=UTF-8")
    public String passObj(DemoObj obj,HttpServletRequest request){

        //return new DemoObj(obj.getId()+1,obj.getName()+"obj");

       // System.out.println("..........."+obj.getId());
        return "url: "+request.getRequestURL()+" can access,obj.id ="+obj.getId()+" obj.name:"+obj.getName();

    }


    @RequestMapping(value={"/name1","/name2"},produces = "text/plain;charset=UTF-8")

    public  @ResponseBody String remove(HttpServletRequest request){
        return "url:"+request.getRequestURL()+" can access...";
    }


}

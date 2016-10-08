package com.spring4.mvc.domain;/**
 * Created by user on 16/10/4.
 */

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * restController
 *
 * @author user
 * @create 2016 -10-04 下午10:23
 */
@RestController
@RequestMapping("/rest")
public class DemoRestController {
    //返回类型为json
    @RequestMapping(value = "/getjson",produces = "application/json;charset=UTF-8")
    public DemoObj getjson(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+".json");
    }
    //返回类型问xml
    @RequestMapping(value = "/getxml",produces = "application/xml;charset=UTF-8")
    public DemoObj getxml(DemoObj obj){
        return new DemoObj(obj.getId()+1,obj.getName()+"xml");
    }
}

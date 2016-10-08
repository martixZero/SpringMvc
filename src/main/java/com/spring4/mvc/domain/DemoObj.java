package com.spring4.mvc.domain;/**
 * Created by user on 16/10/4.
 */

/**
 * json
 *
 * @author user
 * @create 2016 -10-04 下午9:51
 */

public class DemoObj {

    private String name;
    private Long id;
    public DemoObj(){
        super();
    }
    public DemoObj(Long id,String name){
        super();
        this.id=id;
        this.name=name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}

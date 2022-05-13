package com.spring.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName RouterController.java
 * @Description 路由跳转controller
 *              在templates目录下的所有页面，只能通过@Controller来跳转
 *                 这个需要模板引擎的支持！thymeleaf
 * @createTime 2022年05月02日 15:14:00
 */
@Controller
public class RouterController {

    @RequestMapping({"/","/index"})
    public String index(){
        return "index";
    }

    @RequestMapping({"/toLogin"})
    public String toLogin(){
        return "views/login";
    }

    @RequestMapping({"/level1/{id}"})
    public String level1(@PathVariable("id") int id){
        return "views/level1/"+id;
    }

    @RequestMapping({"/level2/{id}"})
    public String level2(@PathVariable("id") int id){
        return "views/level2/"+id;
    }

    @RequestMapping({"/level3/{id}"})
    public String level3(@PathVariable("id") int id){
        return "views/level3/"+id;
    }
}

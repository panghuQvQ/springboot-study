package com.spring.springbootstudy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName IndexController.java
 * @Description 在templates目录下的所有页面，只能通过@Controller来跳转
 *               这个需要模板引擎的支持！thymeleaf
 *
 * @createTime 2022年04月09日 16:12:00
 */
@Controller
public class IndexController {

    @RequestMapping("/test")
    public String test(Model model){
        model.addAttribute("msg","hello Springboot"); // 视图添加属性
        model.addAttribute("users", Arrays.asList("wzy","xm"));
        return "test";
    }
}

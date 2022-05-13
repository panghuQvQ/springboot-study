package com.spring.springbootstudy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Params: $
 * @return $
 * @Author: wangzhenyang
 * @Date $
 */
@RestController
@RequestMapping("/hello")
public class HelloController {

    @GetMapping
    public String HelloWorld(){
        return "你好";
    }



}

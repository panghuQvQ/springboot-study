package com.spring.springbootstudy.controller;

import com.spring.springbootstudy.entity.Student;
import com.spring.springbootstudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName StudentController.java
 * @Description TODO
 * @createTime 2022年05月01日 16:46:00
 */
@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/findAll")
    public List<Student> findAll(){
        List<Student> list = studentService.queryList();
        return list;
    }
}

package com.spring.springbootstudy.service;

import com.spring.springbootstudy.entity.Student;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName StudentService.java
 * @Description TODO
 * @createTime 2022年05月01日 17:30:00
 */
public interface StudentService {

    int addStudent(Student student);

    List<Student> queryList();
}

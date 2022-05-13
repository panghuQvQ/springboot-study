package com.spring.springbootstudy.service.impl;

import com.spring.springbootstudy.entity.Student;
import com.spring.springbootstudy.mapper.StudentMapper;
import com.spring.springbootstudy.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName StudentServiceImpl.java
 * @Description TODO
 * @createTime 2022年05月01日 17:30:00
 */
@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    public StudentMapper studentMapper;

    @Override
    public int addStudent(Student student) {
        return 0;
    }

    @Override
    public List<Student> queryList() {
        List<Student> list = studentMapper.queryList();
        return list;
    }
}

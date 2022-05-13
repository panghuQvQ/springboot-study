package com.spring.springbootstudy.mapper;

import com.spring.springbootstudy.entity.Student;
import org.apache.catalina.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName StudentMapper.java
 * @Description TODO
 * @createTime 2022年05月01日 17:03:00
 */
// 表示这是一个mybatis的接口类
@Mapper
@Repository // 被spring整合
public interface StudentMapper {

    List<Student> queryList();

    Student queryById(int id);

    int addStudent(Student student);

    int updateStudent(Student student);

    int deleteStudent(int id);

}

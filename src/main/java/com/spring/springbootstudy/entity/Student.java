package com.spring.springbootstudy.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName Student.java
 * @Description TODO
 * @createTime 2022年05月01日 16:48:00
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String id;

    private int age;

    private String name;
}

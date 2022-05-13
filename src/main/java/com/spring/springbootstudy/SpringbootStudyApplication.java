package com.spring.springbootstudy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class}) //@EnableAutoConfiguration注解的 exclude 属性禁用某些类的自动配置
//标注这个类是springboot的应用：标注这个类是一个Springboot的应用：启动类下的所有资源被导入
@SpringBootApplication
public class SpringbootStudyApplication {

    public static void main(String[] args) {
        //将Springboot应用启动
        SpringApplication.run(SpringbootStudyApplication.class, args);
    }

}

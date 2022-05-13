package com.spring.springbootstudy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName MyMvcConfig.java
 * @Description TODO
 * @createTime 2022年04月09日 16:58:00
 */
// 如果，你想diy一些定制化的功能，只要写这个组件，然后将它交给springboot，springboot就会帮我们自动装配！
// 扩展SpringMVC
@Configuration
@EnableWebMvc
public class MyMvcConfig implements WebMvcConfigurer {

    //ViewResolver 实现了视图解析器接口的类，我们就可以把它看做视图解析器

    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }

    // 自定义了一个自己的视图解析器MyViewResolver
    public static class MyViewResolver implements ViewResolver {
        @Override
        public View resolveViewName(String viewName, Locale locale) throws Exception {
            return null;
        }
    }

}

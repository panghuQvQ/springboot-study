package com.spring.springbootstudy.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @title
 * @description WebSecurityConfigurerAdapter 自定义授权策略
 *              AuthenticationManagerBuilder 自定义认证策略
 *              @EnableWebSecurity：开启WebSecurity模式
 * 注意：@Enablexxxx -->开启某个功能
 * @author admin
 * @updateTime 2022/5/2 18:04
 * @throws
 */
// AOP
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // 授权，链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // 首页所有人可以访问，功能页只有对应有权限的人才能访问
        // 请求授权的规则
        http.authorizeRequests()
                .antMatchers("/").permitAll() // 主页，所有人都可以访问
                .antMatchers("/level1/**").hasRole("vip1")
                .antMatchers("/level2/**").hasRole("vip2")
                .antMatchers("/level3/**").hasRole("vip3");

        // 没有权限默认会到登录页面, 需要开启登录的页面
        // 定制登录页 .loginPage("/toLogin")
        http.formLogin()
                .usernameParameter("username")
                .passwordParameter("password")
                .loginPage("/toLogin")
                .loginProcessingUrl("/login"); // 登陆表单提交请求

        //防止网站攻击
        http.csrf().disable(); //关闭csrf功能:跨站请求伪造,默认只能通过post方式提交logout请求

        // 开启注销功能
        http.logout().logoutSuccessUrl("/");

        // 开启记住我功能,  rememberMeParameter()定制记住我的参数！
        http.rememberMe().rememberMeParameter("remember");
    }

    // 定义认证规则
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

        //在内存中定义，也可以在jdbc中去拿....
        //Spring security 5.0中新增了多种加密方式，也改变了密码的格式。
        //要想我们的项目还能够正常登陆，需要修改一下configure中的代码。我们要将前端传过来的密码进行某种方式加密
        //spring security 官方推荐的是使用bcrypt加密方式。
        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
                .withUser("wzy").password(new BCryptPasswordEncoder().encode("123")).roles("vip2","vip3")
                .and()
                .withUser("root").password(new BCryptPasswordEncoder().encode("123")).roles("vip1","vip2","vip3");
    }
}

package com.spring.springbootstudy.config;
import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import javax.sql.DataSource;
import java.util.HashMap;

/**
 * @author wzy
 * @version 1.0.0
 * @ClassName DruidConfig.java
 * @Description TODO
 * @createTime 2022年05月01日 23:03:00
 */

// 输入localhost:端口号/druid--->即可进入Druid Monitor页面
@Configuration
public class DruidConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource druidDataSource(){
        return new DruidDataSource();
    }

    // 后台监控功能
    @Bean
    public ServletRegistrationBean StatViewServlet(){
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<>(new StatViewServlet(), "/druid/*");

        // 后台需要有人登录，账号密码配置
        HashMap<String, String> initParameters = new HashMap<>();

        // 增加配置
        initParameters.put("loginUsername","admin"); // 登录的key 是固定的 loginUsername loginPassword
        initParameters.put("loginPassword","123456");

        /**
         * 允许谁可以访问,
         * value为空，代表所有人都可以访问
         * value为localhost，只有本机可以访问
         */
        initParameters.put("allow","");

        // 禁止谁能访问  initParameters.put("xxx","172.16.10.132");

        bean.setInitParameters(initParameters); // 设置初始化参数
        return bean;
    }

    // filter
    @Bean
    public FilterRegistrationBean webStatFilter(){

        FilterRegistrationBean<Filter> bean = new FilterRegistrationBean<>();
        bean.setFilter(new WebStatFilter());

        // 可以过滤拿些请求呢？
        HashMap<String, String> initParameters = new HashMap<>();
        // 这些东西不进行统计~~
        initParameters.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParameters);
        return bean;
    }
}

package com.ty.config;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/5/11.
 */
@Configuration
public class DruidConfig {
    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource bindPropertyToDruig(){
        return new DruidDataSource();
    }
    //配置一个管理后台的servlet
    @Bean
    public ServletRegistrationBean statViweServlet(){
        ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(),
                "/druid/*");
        Map<String,String> map = new HashMap<>();
        map.put("loginUsername","admin");
        //为druid的druid.html设置用户名和密码
        map.put("loginPassword","123456");
        //所有都能进行访问
        map.put("allow","");
        bean.setInitParameters(map);
        return bean;
    }
    //配置filter监控来访问
    @Bean
    public FilterRegistrationBean filter(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new WebStatFilter());
        Map<String,String> map = new HashMap<>();
        //不拦截哪些
        map.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(map);
        //拦截哪些
        bean.setUrlPatterns(Arrays.asList("/*"));
        return bean;
    }
}

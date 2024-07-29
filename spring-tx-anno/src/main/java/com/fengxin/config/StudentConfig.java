package com.fengxin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@Configuration
@ComponentScan(basePackages = "com.fengxin")
@PropertySource (value = "classpath:jdbc.properties")
public class StudentConfig {
    // 配置连接池
    @Bean
    public DataSource dataSource(@Value ("${url}") String url,
                                 @Value ("${driver}") String driver,
                                 @Value ("${username}") String username,
                                 @Value ("${password}") String password){
        DruidDataSource source = new DruidDataSource ();
        source.setUrl (url);
        source.setDriverClassName (driver);
        source.setUsername (username);
        source.setPassword (password);
        return source;
    }
    // 配置jdbc
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        return new JdbcTemplate (dataSource);
    }
}

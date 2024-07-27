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
 * @date 2024/7/27
 **/
@Configuration
@ComponentScan(basePackages = {"com.fengxin"})
@PropertySource ("classpath:jdbc.properties")
public class JavaConfig {
    // 创建连接池
    @Bean
    public DataSource dataSource(@Value ("${url}") String url,@Value ("${driver}") String driver,@Value ("${username}") String username,@Value ("${password}") String password){
        DruidDataSource druidDataSource = new DruidDataSource ();
        druidDataSource.setUrl (url);
        druidDataSource.setDriverClassName (driver);
        druidDataSource.setUsername (username);
        druidDataSource.setPassword (password);
        return druidDataSource;
    }
    // jdbc
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource dataSource){
        JdbcTemplate jdbcTemplate = new JdbcTemplate ();
        jdbcTemplate.setDataSource (dataSource);
        return jdbcTemplate;
    }
}

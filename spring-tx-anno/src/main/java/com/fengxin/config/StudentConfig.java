package com.fengxin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import javax.sql.DataSource;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@Configuration
@ComponentScan(basePackages = "com.fengxin")
@PropertySource (value = "classpath:jdbc.properties")
// 开启事物支持
@EnableTransactionManagement
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
    
    /**
     * 配置事物管理器 @Transactional
     * 方法：当前方法事务
     * 类：类中所有方法都有事务
     * @param dataSource 连接池
     * @return 事务
     */
    @Bean
    public TransactionManager transactionManager(DataSource dataSource){
        // 选择合适的事物管理器
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager ();
        // 基于连接池
        dataSourceTransactionManager.setDataSource (dataSource);
        return dataSourceTransactionManager;
    }
}

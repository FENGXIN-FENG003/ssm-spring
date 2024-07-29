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
@Transactional
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
     * 1. 只读模式
     * 事务默认非只读 boolean readOnly() default false;
     * 一般将事务加在类上
     * 如果有方法只做查询 则覆盖事务 提高查询效率
     * 2. 超时时间
     * 默认 -1 不限定时间
     * 设置@Transactional(timeout = 整秒数) 超时回滚事务释放资源 异常信息
     * 如果在了类上设置超时 方法设置@Transactional但没有超时 则不会生效（方法覆盖了类的注解）
     *
     * @param dataSource 连接池
     * @return 事务
     */
    
    public TransactionManager transactionManager(DataSource dataSource){
        // 选择合适的事物管理器
        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager ();
        // 基于连接池
        dataSourceTransactionManager.setDataSource (dataSource);
        return dataSourceTransactionManager;
    }
    @Transactional(readOnly = true,timeout = 1)
    public void query(){
    }
}

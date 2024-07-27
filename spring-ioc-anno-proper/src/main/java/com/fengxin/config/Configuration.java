package com.fengxin.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

/**
 * @author FENGXIN
 * @date 2024/7/27
 * 配置类开发
 **/
//标注当前类是配置类
@org.springframework.context.annotation.Configuration
//使用注解读取外部配置
@PropertySource ("classpath:jdbc.properties")
//使用@ComponentScan注解,可以配置扫描包 可以有多个包
@ComponentScan(basePackages = {"com.fengxin.ioc_01"})
public class Configuration {
    /**
     * `@Bean` 注释用于指示方法实例化、配置和初始化要由 Spring IoC 容器管理的新对象
       方法返回值类型 == bean组件类型 / 实现的接口 / 父类
       bean注解会让方法创建的组件配置到ioc容器
     * beanName： 1. 默认方法名
*                 2. 覆盖 value / name属性
     * 周期方法指定：1. @PostConstruct + @PreDestroy指定方法
     *              2. 属性initMethod destroyMethod
     * 作用域：@Scope
     * 引用其他ioc组件：1. 直接调用对方bean方法
     *                 2. 形参变量（只有一个时变量名随意）引入 前提必须有组件 有多个: 形参 = 组件id
     */
    @Bean(name = "data",initMethod = "",destroyMethod = "")
    @Scope(scopeName = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public DataSource dataSource(@Value ("${url}") String url,
                                 @Value ("${driver}") String driver,
                                 @Value ("${username}") String username,
                                 @Value ("${password}") String password){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl (url);
        dataSource.setDriverClassName (driver);
        dataSource.setUsername (username);
        dataSource.setPassword (password);
        return dataSource;
    }
    @Bean
    public JdbcTemplate jdbcTemplate(DataSource data){
        JdbcTemplate jdbcTemplate = new JdbcTemplate ();
        jdbcTemplate.setDataSource (data);
        return jdbcTemplate;
    }
}

package com.fengxin.config;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @author FENGXIN
 * @date 2024/7/28
 **/
@Configuration
// 扫描增强类进入ioc
@ComponentScan(basePackages = {"com.fengxin"})
// 开启aop
@EnableAspectJAutoProxy
public class JavaConfig {
}

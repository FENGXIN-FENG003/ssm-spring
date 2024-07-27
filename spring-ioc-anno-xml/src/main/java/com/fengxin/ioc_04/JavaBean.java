package com.fengxin.ioc_04;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author FENGXIN
 * @date 2024/7/26
 * 基本类型装配 DI
 **/
@Component
public class JavaBean {
    // 直接赋值
    private String name = "枫";
    // 使用value注解
    @Value ("18")
    private int age;
    // value注解一般用于读取外部配置文件
    // 默认值
    @Value ("${username:FENGXIN}")
    private String username;
    
    @Override
    public String toString () {
        return "JavaBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
    
    @Value ("${password}")
    private String password;
    
}

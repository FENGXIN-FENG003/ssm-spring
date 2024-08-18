package com.fengxin.ioc;

import com.fengxin.annotation.MyComponentScan;
import com.fengxin.config.MySpringConfig;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author FENGXIN
 * @date 2024/8/18
 * @project ssm-spring
 * @description ioc容器
 **/
public class MySpringApplicationContext {
    // 配置类对象
    private final Class<?> mySpringConfigClass;
    // ioc容器 存放构建的组件bean
    private final ConcurrentHashMap<String,Object> iocMap = new ConcurrentHashMap<>();
    // 构造函数 ioc容器实现逻辑将在这里
    public MySpringApplicationContext(Class<?> mySpringConfigClass) {
        // 配置类对象初始化
        this.mySpringConfigClass = mySpringConfigClass;
        
        // 获取@MyComponentScan
        MyComponentScan scan = mySpringConfigClass.getDeclaredAnnotation (MyComponentScan.class);
        
        // 获取@MyComponentScan的扫描包路径
        String packagePath = scan.value ();
        System.out.println ("packagePath = " + packagePath);
    }
}

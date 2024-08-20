package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Component;
import com.fengxin.myspring.processor.BeanPostProcessor;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
// 放入ioc容器管理
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization (Object bean , String beanName) {
        // 切面编程 可以在这里对所有的bean进行一些处理 如日志 身份...
        System.out.println ("before..." + " bean: " + bean + " beanName: " + beanName);
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization (Object bean , String beanName) {
        // 切面编程 可以在这里对所有的bean进行一些处理 如日志 身份...
        System.out.println ("before..." + " bean: " + bean + " beanName: " + beanName);
        return bean;
    }
}

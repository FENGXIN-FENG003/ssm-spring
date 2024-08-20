package com.fengxin.myspring.ioc;

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
        System.out.println ("before...");
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization (Object bean , String beanName) {
        System.out.println ("after...");
        return bean;
    }
}

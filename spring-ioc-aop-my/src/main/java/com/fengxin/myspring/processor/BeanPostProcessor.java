package com.fengxin.myspring.processor;


import com.fengxin.myspring.annotation.Component;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
public interface BeanPostProcessor {
    /**
     * 初始化方法前执行
     */
    default Object postProcessBeforeInitialization(Object bean, String beanName) {
        return bean;
    }
    
    /**
     * 初始化方法后执行
     */
    default Object postProcessAfterInitialization(Object bean, String beanName) {
        return bean;
    }
}

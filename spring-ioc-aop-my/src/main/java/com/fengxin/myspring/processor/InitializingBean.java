package com.fengxin.myspring.processor;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description 初始化接口 set bean后实现了此接口 spring容器自动调用afterPropertiesSet方法 即初始化方法
 **/
public interface InitializingBean {
    
    void afterPropertiesSet() throws Exception;
}

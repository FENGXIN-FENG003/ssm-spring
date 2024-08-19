package com.fengxin.myspring.ioc;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description 存放bean对象相关信息 当多例时 返回类对象 单例时 返回SingletonMap里的bean
 **/
public class BeanDefinition {
    private String scope;
    private Class<?> beanClass;
    
    public BeanDefinition () {
    }
    
    public String getScope () {
        return scope;
    }
    
    public void setScope (String scope) {
        this.scope = scope;
    }
    
    public Class<?> getBeanClass () {
        return beanClass;
    }
    
    public void setBeanClass (Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}

package com.fengxin.ioc_02;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author FENGXIN
 * @date 2024/7/26
 * Bean作用域概念<br>
 * bean标签声明Bean，只是将Bean的信息配置给SpringIoC容器<br>
 * 在IoC容器中，这些 bean 标签对应的信息转成Spring内部 `BeanDefinition` 对象，`BeanDefinition` 对象内，包含定义的信息（id,class,属性等等）！<br>
 * 这意味着，`BeanDefinition`与`类`概念一样，SpringIoC容器可以可以根据`BeanDefinition`对象反射创建多个Bean对象实例。<br>
 * 具体创建多少个Bean的实例对象，由Bean的作用域Scope属性指定<br>
 **/
// 作用域 多例 不会调用周期方法
@Scope(scopeName = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
@Component
public class JavaBean {
    // 初始化方法
    @PostConstruct
    public void init(){
        System.out.println ("init...");
    }
    // 销毁方法
    @PreDestroy
    public void clear(){
        System.out.println ("destroy...");
    }
}

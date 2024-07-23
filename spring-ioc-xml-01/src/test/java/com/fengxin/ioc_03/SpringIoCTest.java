package com.fengxin.ioc_03;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/23
 **/
public class SpringIoCTest {
    public void createIoC(){
        // 创建ioc容器
        // 1.直接创建
        // 这里使用类路径容器 参数可以有多个
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-03.xml");
        // 2.先实例化，再指定配置文件，最后刷新容器触发Bean实例化动作 [springmvc源码和contextLoadListener源码方式]
        ClassPathXmlApplicationContext applicationContext1 = new ClassPathXmlApplicationContext ();
        // 设置配置文件,方法参数为可变参数,可以设置一个或者多个配置
        applicationContext1.setConfigLocations("spring-03.xml");
        // 需要调用refresh方法,触发刷新配置
        applicationContext1.refresh ();
    }
    
    @Test
    // Bean对象读取
    public void getBeanFromIoc(){
        // 配置ioc容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-03.xml");
        // 1.根据id获取bean 返回的是Object 需要自己强转
        HappyComponent happyComponent = (HappyComponent) applicationContext.getBean ("happyComponent");
        // 配置两个或者以上出现: org.springframework.beans.factory.NoUniqueBeanDefinitionException 问题
        // happyComponent.doWork ();
        // 2.根据id和类获取
        HappyComponent happyComponent1 = applicationContext.getBean ("happyComponent",HappyComponent.class);
        // 3.根据类获取
        // 根据类型来获取bean时，在满足bean唯一性的前提下，其实只是看：对象 instanceof 指定的类型』的返回结果
        // 只要返回的是true就可以认定为和类型匹配，能够获取到。
        HappyComponent happyComponent2 = applicationContext.getBean (HappyComponent.class);
        // 使用组件
        happyComponent2.doWork ();
        // 单例模式 实际上三个都是同一个对象
        System.out.println (happyComponent == happyComponent1);
        System.out.println (happyComponent == happyComponent2);
        
    }
    
}

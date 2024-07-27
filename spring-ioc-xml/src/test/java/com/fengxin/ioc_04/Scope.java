package com.fengxin.ioc_04;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/24
 * 组件周期方法配置
 **/
public class Scope {
    @Test
    public void scopeTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-04.xml");
        JavaBean1 bean = applicationContext.getBean (JavaBean1.class);
        JavaBean1 bean1 = applicationContext.getBean (JavaBean1.class);
        // 单例模式 同一个对象
        System.out.println (bean == bean1);
    }
}

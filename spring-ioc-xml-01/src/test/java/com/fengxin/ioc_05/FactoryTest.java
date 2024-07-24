package com.fengxin.ioc_05;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/24
 **/
public class FactoryTest {
    @Test
    public void test(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-05.xml");
        // 从工厂getObject获取JavaBean实例
        JavaBean javaBean = applicationContext.getBean ("javaBean" , JavaBean.class);
        System.out.println (javaBean);
        // 获取工厂 bean标签的 & + id
        Object factoryBean = applicationContext.getBean ("&javaBean");
        System.out.println (factoryBean);
    }
}

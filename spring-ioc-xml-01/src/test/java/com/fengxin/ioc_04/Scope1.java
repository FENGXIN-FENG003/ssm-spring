package com.fengxin.ioc_04;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/24
 **/
public class Scope1 {
    @Test
    public void scopeTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("Spring-04.xml");
        JavaBean2 bean = applicationContext.getBean (JavaBean2.class);
        JavaBean2 bean2 = applicationContext.getBean (JavaBean2.class);
        // 多例 不是同一个对象
        System.out.println (bean == bean2);
    }
}

package com.fengxin.annotation;

import com.fengxin.ioc_01.FfComponent;
import com.fengxin.ioc_01.FfController;
import com.fengxin.ioc_01.FfDao;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/25
 **/
public class SpringTest {
    
    /**
     * 扫描注解
     */
    @Test
    public void oneTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-01-one.xml");
        // 扫描
        FfController bean = applicationContext.getBean (FfController.class);
        System.out.println (bean);
        applicationContext.close ();
    }
    
    /**
     * 测试不扫描的注解
     */
    @Test
    public void twoTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-01-two.xml");
        FfDao ffDao = applicationContext.getBean (FfDao.class);
        System.out.println (ffDao);
        applicationContext.close ();
    }
    /**
     * 扫描指定注解
     */
    @Test
    public void threeTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-01-three.xml");
        FfComponent fComponent = (FfComponent) applicationContext.getBean ("fComponent");
        System.out.println (fComponent);
        applicationContext.close ();
    }
}

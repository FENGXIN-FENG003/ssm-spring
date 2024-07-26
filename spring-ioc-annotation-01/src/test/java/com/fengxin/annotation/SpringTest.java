package com.fengxin.annotation;

import com.fengxin.ioc_01.FfComponent;
import com.fengxin.ioc_01.FfController;
import com.fengxin.ioc_01.FfDao;
import com.fengxin.ioc_02.JavaBean;
import com.fengxin.ioc_03.UserController_01;
import com.fengxin.ioc_03.UserController_02;
import com.fengxin.ioc_03.UserController_03;
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
    
    /**
     * 测试周期和作用域
     */
    @Test
    public void TimeTest(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-02.xml");
        JavaBean bean1 = applicationContext.getBean (JavaBean.class);
        JavaBean bean2 = applicationContext.getBean (JavaBean.class);
        // 多例不会调用销毁方法
        System.out.println (bean1 == bean2);
    }
    
    /**
     * DI 01
     */
    @Test
    public void DITest01(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-03.xml");
        UserController_01 bean = applicationContext.getBean (UserController_01.class);
        bean.show ();
        applicationContext.close ();
    }
    /**
     * DI 02
     */
    @Test
    public void DITest02(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-03.xml");
        UserController_02 bean = applicationContext.getBean (UserController_02.class);
        bean.show ();
        applicationContext.close ();
    }
    /**
     * DI 03
     */
    @Test
    public void DITest03(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-03.xml");
        UserController_03 bean = applicationContext.getBean (UserController_03.class);
        bean.show ();
        applicationContext.close ();
    }
}

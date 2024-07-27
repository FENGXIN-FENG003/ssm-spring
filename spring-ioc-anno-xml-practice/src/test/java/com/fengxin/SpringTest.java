package com.fengxin;

import com.fengxin.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
public class SpringTest {
    @Test
    public void testRun(){
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring.xml");
        StudentController bean = applicationContext.getBean (StudentController.class);
        bean.queryAll ();
        applicationContext.close ();
    }
    
}

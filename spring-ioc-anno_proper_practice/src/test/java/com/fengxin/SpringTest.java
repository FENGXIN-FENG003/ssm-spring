package com.fengxin;

import com.fengxin.config.JavaConfig;
import com.fengxin.controller.StudentController;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/27
 **/
public class SpringTest {
    @Test
    public void testRun(){
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext (JavaConfig.class);
        StudentController bean = applicationContext.getBean (StudentController.class);
        bean.queryAll ();
        applicationContext.close ();
    }
    
}

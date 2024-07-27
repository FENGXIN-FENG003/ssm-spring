package com.fengxin;

import com.fengxin.config.Configuration;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/27
 **/
public class SpringTest {
    @Test
    public void Test01(){
        // 创建ioc容器
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext (Configuration.class);
        
    }
}

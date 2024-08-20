package com.fengxin.myspring.test;

import com.fengxin.myspring.component.MyDao;
import com.fengxin.myspring.component.MyService;
import com.fengxin.myspring.config.SpringConfiguration;
import com.fengxin.myspring.ioc.SpringApplicationContext;
import org.junit.jupiter.api.Test;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
public class MyTest {
    @Test
    public void setBean() throws Exception {
        SpringApplicationContext springApplicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        MyService bean = (MyService) springApplicationContext.getBean ("service");
        bean.printService ();
    }
    
    @Test
    public void init() throws Exception {
        SpringApplicationContext applicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        MyDao myDao =(MyDao) applicationContext.getBean ("myDao");
    }
}

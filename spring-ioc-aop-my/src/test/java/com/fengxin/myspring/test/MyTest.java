package com.fengxin.myspring.test;

import com.fengxin.myspring.component.MyDao;
import com.fengxin.myspring.component.MyService;
import com.fengxin.myspring.component.SmartCalculate;
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
    /**
     * 测试ioc容器
     * @throws Exception 异常
     */
    @Test
    public void setBean() throws Exception {
        SpringApplicationContext springApplicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        MyService bean = (MyService) springApplicationContext.getBean ("service");
        bean.printService ();
    }
    
    /**
     * 测试后置处理器
     * @throws Exception 异常
     */
    @Test
    public void init() throws Exception {
        SpringApplicationContext applicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        MyDao myDao =(MyDao) applicationContext.getBean ("myDao");
        myDao.printDao ();
    }
    
    /**
     * 测试代理 aop
     */
    @Test
    public void proxy() throws Exception {
        SpringApplicationContext applicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        SmartCalculate myCalculate = (SmartCalculate) applicationContext.getBean ("myCalculate");
        System.out.println ("myCalculate.getClass () = " + myCalculate.getClass ());
        // 通过代理对象调用方法 实现aop
        myCalculate.add (1,2);
    }
}

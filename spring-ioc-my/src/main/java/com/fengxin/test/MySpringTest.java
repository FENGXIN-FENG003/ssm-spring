package com.fengxin.test;

import com.fengxin.config.MySpringConfig;
import com.fengxin.ioc.MySpringApplicationContext;
import com.fengxin.spring.MyController;
import com.fengxin.spring.MyDao;
import com.fengxin.spring.MyService;

/**
 * @author FENGXIN
 * @date 2024/8/18
 * @project ssm-spring
 * @description 测试
 **/
public class MySpringTest {
    public static void main (String[] args) throws Exception {
        MySpringApplicationContext ioc = new MySpringApplicationContext (MySpringConfig.class);
        MyController controller = (MyController) ioc.getBean ("controller");
        MyService myService = (MyService)ioc.getBean ("MyService");
        MyDao myDao = (MyDao)ioc.getBean ("MyDao");
    }
}

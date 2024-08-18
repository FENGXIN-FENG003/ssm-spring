package com.fengxin.test;

import com.fengxin.config.MySpringConfig;
import com.fengxin.ioc.MySpringApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/8/18
 * @project ssm-spring
 * @description 测试
 **/
public class MySpringTest {
    public static void main (String[] args) {
        MySpringApplicationContext ioc = new MySpringApplicationContext (MySpringConfig.class);
        
    }
}

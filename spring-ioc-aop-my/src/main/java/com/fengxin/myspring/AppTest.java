package com.fengxin.myspring;

import com.fengxin.myspring.config.SpringConfiguration;
import com.fengxin.myspring.ioc.SpringApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description
 **/
public class AppTest {
    public static void main (String[] args) throws Exception {
        SpringApplicationContext springApplicationContext =
                new SpringApplicationContext (SpringConfiguration.class);
        
    }
}

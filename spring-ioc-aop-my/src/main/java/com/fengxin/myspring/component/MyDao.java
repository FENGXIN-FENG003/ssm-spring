package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Repository;
import com.fengxin.myspring.processor.InitializingBean;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description
 **/
@Repository
public class MyDao implements InitializingBean {
    public void printDao() {
        System.out.println("MyDao");
    }
    
    @Override
    public void afterPropertiesSet () throws Exception {
        System.out.println ("dao init...");
    }
}

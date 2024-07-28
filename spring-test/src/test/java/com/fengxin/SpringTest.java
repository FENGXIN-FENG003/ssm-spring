package com.fengxin;

import com.fengxin.config.JavaConfig;
import com.fengxin.service.A;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * spring测试环境搭建
 **/
@SpringJUnitConfig(value = JavaConfig.class)
public class SpringTest {
    @Autowired
    private A a;
    @Test
    public void test(){
        System.out.println ("a = " + a);
    }
}

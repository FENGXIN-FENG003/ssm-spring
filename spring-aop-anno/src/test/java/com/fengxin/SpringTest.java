package com.fengxin;

import com.fengxin.config.JavaConfig;
import com.fengxin.service.Calculator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;


/**
 * @author FENGXIN
 * @date 2024/7/28
 **/
@SpringJUnitConfig(JavaConfig.class)
public class SpringTest {
    @Autowired
    private Calculator calculator;
    @Test
    public void advanceAddTest(){
        int result = calculator.add (1,1);
        System.out.println ("result = " + result);
    }
    @Test
    public void advanceDivTest(){
        int result = calculator.div (1,0);
        System.out.println ("result = " + result);
    }
}

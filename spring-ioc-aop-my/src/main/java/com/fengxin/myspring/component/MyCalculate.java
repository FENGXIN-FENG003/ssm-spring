package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Component;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
@Component
public class MyCalculate implements SmartCalculate{
    
    @Override
    public int add (int a , int b) {
        int result = a + b;
        System.out.println (a + " + " + b + " = " + result);
        return result;
    }
    
    @Override
    public int sub (int a , int b) {
        int result = a - b;
        System.out.println (a + " - " + b + " = " + result);
        return result;
    }
}

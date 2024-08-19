package com.fengxin.service.impl;

import com.fengxin.service.Calculator;
import org.springframework.stereotype.Component;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * aop核心代码
 **/
@Component
public class CalculatorImpl implements Calculator {
    @Override
    public int add(int i, int j) {
        int result = i + j;
        System.out.println ("计算结果 = " + result);
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
        int result = i - j;
        System.out.println ("计算结果 = " + result);
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
        int result = i * j;
        System.out.println ("计算结果 = " + result);
        return result;
    }
    
    @Override
    public int div(int i, int j) {
        int result = i / j;
        System.out.println ("计算结果 = " + result);
        return result;
    }
}

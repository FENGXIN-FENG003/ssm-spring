package com.fengxin.advance;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * 增强类 解决非核心业务代码冗余问题
 * 1. 编写非核心方法 数量根据需要插入的位置决定
 * 2. 加入注解 决定方法插入在哪里
 *                              前置通知 返回通知 异常通知 后置通知 环绕通知
 * 4. 配置切点表达式（切点决定）
 * 5. 补全注解 将增强类加入ioc容器；配置切面 切点+增强代码
 * 6. 开启aop 在配置中@EnableAspectJAutoProxy
 **/
@Component
// 配置切点
@Aspect
public class CalculatorAdvance {
    // 加入注解 切点表达式
    @Before (value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))")
    public void pre(){
        System.out.println ("开始...");
    }
    @After (value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))")
    public void end(){
        System.out.println ("结束...");
    }
    @AfterThrowing(value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))")
    public void exception(){
        System.out.println ("异常...");
    }
}

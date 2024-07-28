package com.fengxin.advance;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * 获取目标信息
 * 1. 获取方法所属类 方法名 参数 访问修饰符......
 * 2. 获取返回结果
 * 3. 获取异常信息
 **/
@Component
@Aspect
public class GetMessageAdvance {
    // 获取方法所属类 方法名 参数 访问修饰符
    @Before (value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))")
    // 需要加上形参JoinPoint joinPoint
    public void before(JoinPoint joinPoint){
        // 获取目标类名
        String simpleName = joinPoint.getTarget ().getClass ().getSimpleName ();
        // 获取方法名
        String name = joinPoint.getSignature ().getName ();
        // 获取方法参数
        Object[] args = joinPoint.getArgs ();
        // 获取访问修饰符
        int modifiers = joinPoint.getSignature ().getModifiers ();
        String modify = Modifier.toString (modifiers);
        
        System.out.println ("目标类名："+simpleName);
        System.out.println ("方法名："+name);
        System.out.println ("方法参数："+ Arrays.toString (args));
        System.out.println ("访问修饰符："+modify);
    }
    // 获取返回结果
    // 形参Object result 注解参数returning = "result"
    @AfterReturning(value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))",returning = "result")
    public void afterReturning(Object result){
        System.out.println ("方法执行完毕，返回结果为："+result);
    }
    // 获取异常信息
    // 形参Throwable e 注解参数throwing = "e"
    @AfterThrowing(value = "execution(* com.fengxin.service.impl.CalculatorImpl.*(..))",throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println ("方法执行异常，异常信息为："+e);
    }
}

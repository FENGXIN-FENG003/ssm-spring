package com.fengxin.advance;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * 获取目标信息<br>
 * 1. 获取方法所属类 方法名 参数 访问修饰符......<br>
 * 2. 获取返回结果<br>
 * 3. 获取异常信息<br>
 **/
// @Component
// @Aspect
// @Order(2)
public class GetMessageAdvance {
    // 获取方法所属类 方法名 参数 访问修饰符
    @Before (value = "com.fengxin.pointcut.MyPointCut.myPointCut1()")
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
    // 形参：Object result 注解参数：returning = "result"
    @AfterReturning(value = "com.fengxin.pointcut.MyPointCut.myPointCut1()",returning = "result")
    public void afterReturning(Object result){
        System.out.println ("方法执行完毕，返回结果为："+result);
    }
    // 获取异常信息
    // 形参：Throwable e 注解参数：throwing = "e"
    @AfterThrowing(value = "com.fengxin.pointcut.MyPointCut.myPointCut1()",throwing = "e")
    public void afterThrowing(Throwable e){
        System.out.println ("方法执行异常，异常信息为："+e);
    }
}

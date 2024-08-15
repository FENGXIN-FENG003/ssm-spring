package com.fengxin.advance;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * 环绕通知 需要定义目标方法的执行（ProceedingJoinPoint proceedingJoinPoint）
 * 注意：环绕增强方法必须有一个Object返回值，否则会报错
 * 目标信息 + 执行目标
 * 目标方法的返回值
 **/
@Component
@Aspect
// 设置优先级 值越小优先级越高 先开后关
@Order(1)
public class AroundAdvance {
    // 使用@Around注解标明环绕通知方法
    @Around ("com.fengxin.pointcut.MyPointCut.myPointCut1()")
    public Object around(
            // 通过在通知方法形参位置声明ProceedingJoinPoint类型的形参，
            // Spring会将这个类型的对象传给我们
            ProceedingJoinPoint proceedingJoinPoint){
        // 获取方法参数 保证目标方法被执行即可
        Object[] args = proceedingJoinPoint.getArgs ();
        Object result;
        try {
            // 增强代码
            System.out.println ("环绕开始" + Arrays.toString (args));
            // 执行目标方法
            // 过ProceedingJoinPoint对象调用目标方法
            // 目标方法的返回值一定要返回给外界调用者
            result = proceedingJoinPoint.proceed (args);
            System.out.println ("环绕结束" + result);
        }catch (Throwable e){
            System.out.println ("事物回滚" + e.getMessage());
            // 必须再抛出异常 否则调用者拿不到异常
            throw new RuntimeException (e);
        }
        return result;
    }

}

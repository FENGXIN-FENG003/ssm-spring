package com.fengxin.pointcut;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @author FENGXIN
 * @date 2024/7/28
 * 统一管理切点类
 * 也需要放入ioc容器
 **/
@Component
public class MyPointCut {
    /**
     * public void 随意方法名
     */
    @Pointcut("execution(* com.fengxin.service.impl.CalculatorImpl.*(..))")
    public void myPointCut1(){}
}

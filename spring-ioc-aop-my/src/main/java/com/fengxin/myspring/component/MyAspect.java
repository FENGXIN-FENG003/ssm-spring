package com.fengxin.myspring.component;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
public class MyAspect {
    
    public static void beforeLog(){
        System.out.println ("前置通知");
    }
    public static void afterLog(){
        System.out.println ("返回通知");
    }
    public static void afterThrowingeLog(){
        System.out.println ("异常通知");
    }
    public static void finallyLog(){
        System.out.println ("最终通知");
    }
}

package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Component;
import com.fengxin.myspring.processor.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author FENGXIN
 * @date 2024/8/20
 * @project ssm-spring
 * @description
 **/
// 放入ioc容器管理
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization (Object bean , String beanName) {
        // 切面编程 可以在这里对所有的bean进行一些处理 如日志 身份...
        System.out.println ("before..." + " bean: " + bean + " beanName: " + beanName);
        return bean;
    }
    
    @Override
    public Object postProcessAfterInitialization (Object bean , String beanName) {
        // 切面编程 可以在这里对所有的bean进行一些处理 如日志 身份...
        System.out.println ("after..." + " bean: " + bean + " beanName: " + beanName);
        // 返回代理对象 实现aop
        if ("myCalculate".equals (beanName)){
            // 创建代理对象 实现相应对应的通知
            // 返回代理对象
            return Proxy.newProxyInstance (MyBeanPostProcessor.class.getClassLoader () , bean.getClass ().getInterfaces () ,
                    new InvocationHandler () {
                @Override
                public Object invoke (Object proxy , Method method , Object[] args) throws Throwable {
                    System.out.println ("methodName: " + method.getName ());
                    Object invoke;
                    // 假如只实现add方法
                    if ("add".equals (method.getName ())) {
                        // 假如只实现前置 返回通知
                        MyAspect.beforeLog ();
                        // 执行目标方法
                        invoke = method.invoke (bean , args);
                        MyAspect.afterLog ();
                    } else {
                        invoke = method.invoke (bean , args);
                    }
                    return invoke;
                }
            });
        }
        // 不需要aop 直接返回原生对象
        return bean;
    }
}

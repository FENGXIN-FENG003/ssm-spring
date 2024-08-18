package com.fengxin.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author FENGXIN
 * @date 2024/8/18
 * @project ssm-spring
 * @description 扫描注解实现
 **/
// 作用域
@Target(ElementType.TYPE)
// 作用范围
@Retention (RetentionPolicy.RUNTIME)
public @interface MyComponentScan {
    String value() default "";
}

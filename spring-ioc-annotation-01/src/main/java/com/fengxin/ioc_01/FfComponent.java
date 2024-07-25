package com.fengxin.ioc_01;

import org.springframework.stereotype.Component;

/**
 * @author FENGXIN
 * @date 2024/7/25
 **/

// 可以自定义BeanName 只有一个值时可省略value
@Component(value = "fComponent")
public class FfComponent {}

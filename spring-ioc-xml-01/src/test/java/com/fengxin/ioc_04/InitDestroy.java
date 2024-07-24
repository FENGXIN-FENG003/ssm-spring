package com.fengxin.ioc_04;

import org.junit.jupiter.api.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author FENGXIN
 * @date 2024/7/23
 * 生命周期
 **/
public class InitDestroy {
    @Test
    public void test(){
        // 容器创建 初始化
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-04.xml");
        // 容器销毁 调用销毁方法销毁bean
        applicationContext.close ();
    }
}

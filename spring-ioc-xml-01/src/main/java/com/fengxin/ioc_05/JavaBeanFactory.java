package com.fengxin.ioc_05;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author FENGXIN
 * @date 2024/7/24
 * `FactoryBean` 接口是Spring IoC容器实例化逻辑的可插拔性点。
 *  用于配置复杂的Bean对象，可以将创建过程存储在`FactoryBean` 的getObject方法
 *  getObject（）返回此工厂创建的对象的实例。该返回值会被存储到IoC容器
 **/
public class JavaBeanFactory implements FactoryBean<JavaBean> {
    // 声明相应属性 方便在配置文件进行实例对象的赋值
    private String name;
    
    public void setName (String name) {
        this.name = name;
    }
    
    @Override
    public JavaBean getObject () throws Exception {
        JavaBean javaBean = new JavaBean ();
        // 属性初始化赋值
        javaBean.setName (name);
        return javaBean;
    }
    
    @Override
    public Class<?> getObjectType () {
        return JavaBean.class;
    }
}

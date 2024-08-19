package com.fengxin.ioc;

import com.fengxin.annotation.MyComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.File;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author FENGXIN
 * @date 2024/8/18
 * @project ssm-spring
 * @description ioc容器
 **/
public class MySpringApplicationContext {
    
    // 配置类对象
    private final Class<?> mySpringConfigClass;
    
    // ioc容器 存放构建的组件bean
    private final ConcurrentHashMap<String,Object> iocMap = new ConcurrentHashMap<>();
    
    // 构造函数 ioc容器实现逻辑将在这里
    public MySpringApplicationContext(Class<?> mySpringConfigClass) throws Exception {
        // 配置类对象初始化
        this.mySpringConfigClass = mySpringConfigClass;
        
        // 获取@MyComponentScan
        MyComponentScan scan = mySpringConfigClass.getDeclaredAnnotation (MyComponentScan.class);
        
        // 获取@MyComponentScan的扫描包路径
        String packagePath = scan.value ();
        // 根据target包路径 获取当前包及其子包的.class
        // 1.转换路径
        String path = packagePath.replace (".","/");
        
        // 2.根据类加载器查找target路径url
        ClassLoader classLoader = MySpringApplicationContext.class.getClassLoader ();
        // file:/E:/Java/ssm-spring/spring-ioc-my/target/classes/com/fengxin/spring
        URL targetUrl = classLoader.getResource (path);
        // 3.获取url下的文件
        if (targetUrl != null) {
            // 3.1获取包路径文件
            // E:\Java\ssm-spring\spring-ioc-my\target\classes\com\fengxin\spring
            File file = new File (targetUrl.getFile ());
            
            // 截取E:\Java\ssm-spring\spring-ioc-my\target\classes\ 方便后续截取全类名 用于反射
            String subPrev = file.getAbsolutePath ().substring (0 , file.getAbsolutePath ().length () - path.length ());
            
            // 3.2.遍历文件夹下的所有.class
            if(file.isDirectory ()){
                File[] files = file.listFiles ();
                if (files != null) {
                    for (File f : files) {
                        // E:\Java\ssm-spring\spring-ioc-my\target\classes\com\fengxin\spring\MyService.class
                        // 只处理.class文件
                        if (f.getAbsolutePath ().endsWith (".class")){
                            // 获取全类名 方便反射
                            // 1.截取
                            // 1.1 获取.class下标
                            int classIndex = f.getAbsolutePath ().indexOf (".class");
                            
                            // 1.2 获取全类名
                            String subClassPath = f.getAbsolutePath ().substring (subPrev.length (), classIndex);
                            
                            // 2.转换路径
                            String classPath = subClassPath.replace ("\\" , ".");
                            
                            // 类加载 判断.class是否含有注解 并处理
                            // 此方法不会加载类的静态方法 只用于判断 轻量方便
                            Class<?> aClass = classLoader.loadClass (classPath);
                            if (aClass.isAnnotationPresent (Component.class) ||
                                    aClass.isAnnotationPresent (Controller.class)||
                                    aClass.isAnnotationPresent (Service.class)   ||
                                    aClass.isAnnotationPresent (Repository.class)) {
                                // 类完全加载 实例化 存入ioc容器
                                Class<?> clazz = Class.forName (classPath);
                                String beanName = StringUtils.uncapitalize (clazz.getSimpleName ());
                                // 如果有beanName(注解value)
                                if (aClass.isAnnotationPresent (Component.class)) {
                                    // 获取注解 并将别名赋值
                                    beanName = !aClass.getDeclaredAnnotation (Component.class).value ().isEmpty () ? aClass.getDeclaredAnnotation (Component.class).value () : beanName;
                                } else if (aClass.isAnnotationPresent (Controller.class)) {
                                    beanName = !aClass.getDeclaredAnnotation (Controller.class).value ().isEmpty () ? aClass.getDeclaredAnnotation (Controller.class).value () : beanName;
                                } else if (aClass.isAnnotationPresent (Service.class)) {
                                    beanName = !aClass.getDeclaredAnnotation (Service.class).value ().isEmpty () ? aClass.getDeclaredAnnotation (Service.class).value () : beanName;
                                } else if (aClass.isAnnotationPresent (Repository.class)) {
                                    beanName = !aClass.getDeclaredAnnotation (Repository.class).value ().isEmpty () ? aClass.getDeclaredAnnotation (Repository.class).value () : beanName;
                                }
                                // 类首字母需要小写
                                iocMap.put (beanName, clazz.getDeclaredConstructor ().newInstance ());
                            }
                        }
                    }
                }
            }
        }
    }
    
    /**
     * getBean方法
     * @param name beanName
     * @return bean
     */
    public Object getBean (String name) {
        return iocMap.get (name);
    }
}

package com.fengxin.myspring.ioc;

import com.fengxin.myspring.annotation.*;

import com.fengxin.myspring.processor.BeanPostProcessor;
import com.fengxin.myspring.processor.InitializingBean;
import org.springframework.util.StringUtils;

import java.io.File;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description
 **/
public class SpringApplicationContext {
    // 配置类对象
    private Class<?> mySpringConfigClass;
    
    // 单例bean map 存放单例类对象
    private final ConcurrentHashMap<String, Class<?>> singletonMap = new ConcurrentHashMap<>();
    
    // BeanDefinition map 存放bean信息
    private final ConcurrentHashMap<String, BeanDefinition> beanDefinitionMap = new ConcurrentHashMap<>();
    
    // 存储后置处理器
    private final List<BeanPostProcessor> beanPostProcessors = new ArrayList<> ();
    // 构造函数
    public SpringApplicationContext(Class<?> mySpringConfigClass) throws Exception {
        beanIoc (mySpringConfigClass);
    }
    
    /**
     * 装配ioc容器
     * @param mySpringConfigClass 配置类对象
     * @throws Exception 异常
     */
    public void beanIoc(Class<?> mySpringConfigClass) throws Exception {
        // 配置类对象初始化
        this.mySpringConfigClass = mySpringConfigClass;
        
        // 获取@MyComponentScan
        ComponentScan scan = mySpringConfigClass.getDeclaredAnnotation (ComponentScan.class);
        
        // 获取@MyComponentScan的扫描包路径
        String packagePath = scan.value ();
        
        // 根据target包路径 获取当前包及其子包的.class
        // 1.转换路径
        String path = packagePath.replace (".","/");
        
        // 2.根据类加载器查找target路径url
        ClassLoader classLoader = SpringApplicationContext.class.getClassLoader ();
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
                            
                            // 加载类
                            Class<?> clazz = Class.forName (classPath);
                            if (clazz.isAnnotationPresent (Component.class)
                                    || clazz.isAnnotationPresent (Controller.class)
                                    || clazz.isAnnotationPresent (Service.class)
                                    || clazz.isAnnotationPresent (Repository.class)) {
                                // 默认beanName
                                String beanName = StringUtils.uncapitalize (clazz.getSimpleName ());
                                if (clazz.isAnnotationPresent (Component.class)) {
                                    // 存储后置处理器 方便后续使用
                                    if (BeanPostProcessor.class.isAssignableFrom (clazz)){
                                        BeanPostProcessor beanPostProcessor = (BeanPostProcessor)clazz.getDeclaredConstructor ().newInstance ();
                                        beanPostProcessors.add (beanPostProcessor);
                                    }
                                    // 获取beanName
                                    beanName = !clazz.getDeclaredAnnotation (Component.class).value ().isEmpty () ? clazz.getDeclaredAnnotation (Component.class).value () : beanName;
                                    // 设置BeanDefinition信息
                                    BeanDefinition beanDefinition = new BeanDefinition ();
                                    // 设置scope 默认值是singleton
                                    String scope;
                                    if (clazz.isAnnotationPresent (Scope.class)){
                                        scope = clazz.getDeclaredAnnotation (Scope.class).value ();
                                    } else {
                                        scope = "singleton";
                                    }
                                    beanDefinition.setScope (scope);
                                    // 装配类对象
                                    beanDefinition.setBeanClass (clazz);
                                    // 将BeanDefinition装入map
                                    beanDefinitionMap.put (beanName, beanDefinition);
                                    // 装单例类对象
                                    if ("singleton".equals(scope)) {
                                        singletonMap.put (beanName, clazz);
                                    }
                                } else if (clazz.isAnnotationPresent (Controller.class)) {
                                    
                                    // 获取beanName
                                    beanName = !clazz.getDeclaredAnnotation (Controller.class).value ().isEmpty () ? clazz.getDeclaredAnnotation (Controller.class).value () : beanName;
                                    // 设置BeanDefinition信息
                                    BeanDefinition beanDefinition = new BeanDefinition ();
                                    // 设置scope 默认值是singleton
                                    String scope;
                                    if (clazz.isAnnotationPresent (Scope.class)){
                                        scope = clazz.getDeclaredAnnotation (Scope.class).value ();
                                    } else {
                                        scope = "singleton";
                                    }
                                    beanDefinition.setScope (scope);
                                    // 装配类对象
                                    beanDefinition.setBeanClass (clazz);
                                    // 将BeanDefinition装入map
                                    beanDefinitionMap.put (beanName, beanDefinition);
                                    // 装单例类对象
                                    if ("singleton".equals(scope)) {
                                        singletonMap.put (beanName, clazz);
                                    }
                                } else if (clazz.isAnnotationPresent (Service.class)) {
                                    
                                    // 获取beanName
                                    beanName = !clazz.getDeclaredAnnotation (Service.class).value ().isEmpty () ? clazz.getDeclaredAnnotation (Service.class).value () : beanName;
                                    // 设置BeanDefinition信息
                                    BeanDefinition beanDefinition = new BeanDefinition ();
                                    // 设置scope 默认值是singleton
                                    String scope;
                                    if (clazz.isAnnotationPresent (Scope.class)){
                                        scope = clazz.getDeclaredAnnotation (Scope.class).value ();
                                    } else {
                                        scope = "singleton";
                                    }
                                    beanDefinition.setScope (scope);
                                    // 装配类对象
                                    beanDefinition.setBeanClass (clazz);
                                    // 将BeanDefinition装入map
                                    beanDefinitionMap.put (beanName, beanDefinition);
                                    // 装单例类对象
                                    if ("singleton".equals(scope)) {
                                        singletonMap.put (beanName, clazz);
                                    }
                                } else if (clazz.isAnnotationPresent (Repository.class)) {
                                    
                                    // 获取beanName
                                    beanName = !clazz.getDeclaredAnnotation (Repository.class).value ().isEmpty () ? clazz.getDeclaredAnnotation (Repository.class).value () : beanName;
                                    // 设置BeanDefinition信息
                                    BeanDefinition beanDefinition = new BeanDefinition ();
                                    // 设置scope 默认值是singleton
                                    String scope;
                                    if (clazz.isAnnotationPresent (Scope.class)){
                                        scope = clazz.getDeclaredAnnotation (Scope.class).value ();
                                    } else {
                                        scope = "singleton";
                                    }
                                    beanDefinition.setScope (scope);
                                    // 装配类对象
                                    beanDefinition.setBeanClass (clazz);
                                    // 将BeanDefinition装入map
                                    beanDefinitionMap.put (beanName, beanDefinition);
                                    // 装单例类对象
                                    if ("singleton".equals(scope)) {
                                        singletonMap.put (beanName, clazz);
                                    }
                                }
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
    public Object getBean (String name) throws Exception {
        // 如果beanName存在
        if (beanDefinitionMap.containsKey (name)) {
            BeanDefinition beanDefinition = beanDefinitionMap.get (name);
            // 单例 直接从单例map创建class对象返回
            if ("singleton".equals(beanDefinition.getScope ())) {
                return setBean (singletonMap.get (name));
            } else {
                // 多例 动态创建bean实例返回
                return setBean (beanDefinition.getBeanClass ());
            }
        }else {
            // 没有bean 抛出异常
            throw new NullPointerException (name);
        }
    }
    
    /**
     * 装配bean方法
     */
    public Object setBean(Class<?> clazz) throws Exception {
        // 创建待返回的实例
        Object newInstance = clazz.getDeclaredConstructor ().newInstance ();
        // 首先将需要的第三方对象装配 Autowired
        // 1.遍历所有字段
        for (Field field : clazz.getDeclaredFields()) {
            // 2.确认注解@Autowired
            if (field.isAnnotationPresent (Autowired.class)) {
                // 2.1获取fieldName
                String fieldName = field.getName ();
                Autowired autowired = field.getAnnotation (Autowired.class);
                // 2.1.1如果autowired是必须的 但没有相关的类 抛异常
                if (autowired.required ()) {
                    if (getBean (fieldName) == null) {
                        throw new NullPointerException (fieldName);
                    }
                }
                // 2.2装配bean
                Object bean = getBean (fieldName);
                field.setAccessible (true);
                field.set (newInstance, bean);
            }
        }
        // set bean后实现了此接口 spring容器自动调用afterPropertiesSet方法
        if (newInstance instanceof InitializingBean){
            // 向上转型
             ((InitializingBean) newInstance).afterPropertiesSet ();
        }
        return newInstance;
    }
}

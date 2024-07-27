package com.fengxin.ioc_02;

/**
 * @author FENGXIN
 * @date 2024/7/22
 * DI配置 构造函数
 **/
public class UserService {
    private UserDao userDao;
    // 单个构造参数
    private UserService(UserDao userDao){
        this.userDao = userDao;
    }
    private String name;
    private int age;
    
    // 多个参数
    public UserService (String name , int age , UserDao userDao) {
        this.name = name;
        this.age = age;
        this.userDao = userDao;
    }
}

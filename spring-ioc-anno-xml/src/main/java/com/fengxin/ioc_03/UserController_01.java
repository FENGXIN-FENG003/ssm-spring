package com.fengxin.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author FENGXIN
 * @date 2024/7/26
 * 引用类型自动装配 DI
 * 1.能够找到唯一的 bean：直接执行装配
 * 如果完全找不到匹配这个类型的 bean（有多个实现的类 不知道创建哪一个）：装配失败
 * 没有 @Qualifier 注解：根据 @Autowired 标记位置成员变量的变量名作为 bean 的 id 进行匹配
 **/
@Controller
public class UserController_01 {
    // 在成员变量上直接标记@Autowired注解即可，不需要提供setXxx()方法
    @Autowired
    private UserService userServiceImpl01;
    public void show(){
        String show = userServiceImpl01.show ();
        System.out.println (show);
    }
}

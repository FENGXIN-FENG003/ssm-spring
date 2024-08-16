package com.fengxin.ioc_03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * @author FENGXIN
 * @date 2024/7/26
 * 2.使用 @Qualifier 注解：根据 @Qualifier 注解中指定的名称作为 bean 的id进行匹配
 **/
@Controller
public class UserController_02 {
    
    @Autowired
    @Qualifier(value = "userServiceImpl02")
    private UserService userService;
    public void show(){
        String show = userService.show ();
        System.out.println (show);
    }
}

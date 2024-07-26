package com.fengxin.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;


/**
 * @author FENGXIN
 * @date 2024/7/26
 * 3.使用java的注解'@Resource'
 * 依赖
 * <dependency>
 *     <groupId>jakarta.annotation</groupId>
 *     <artifactId>jakarta.annotation-api</artifactId>
 *     <version>2.1.1</version>
 * </dependency>
 **/
@Controller
public class UserController_03 {
    @Resource(name = "userServiceImpl_01")
    private UserService userService;
    public void show(){
        String show = userService.show ();
        System.out.println (show);
    }
}

package com.fengxin.ioc_03;

import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;


/**
 * @author FENGXIN
 * @date 2024/7/26
 * 3.使用java的注解'@Resource'<br>
 * （1） 首先根据指定名称注入<br>
 *      controller @Resource(name = "userServiceImpl01")<br>
 *      service @Service(value = "userServiceImpl01")<br>
 * （2） 根据属性名注入<br>
 *      controller @Resource private UserService userService;<br>
 *      service @Service(value = "userServiceImpl01")<br>
 * （3） 根据类型注入<br>
 *      controller @Resource private UserService userService;<br>
 *      service @Service <br>
 * 依赖<br>
 * <dependency><br>
 *     <groupId>jakarta.annotation</groupId><br>
 *     <artifactId>jakarta.annotation-api</artifactId><br>
 *     <version>2.1.1</version><br>
 * </dependency><br>
 **/
@Controller
public class UserController_03 {
    @Resource(name = "userServiceImpl01")
    private UserService userService;
    public void show(){
        String show = userService.show ();
        System.out.println (show);
    }
}

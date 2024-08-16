package com.fengxin.ioc_03;

import org.springframework.stereotype.Service;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
// 可以在这里重命名 解决同一个service下的bean冲突
@Service(value = "userServiceImpl02")
public class UserServiceImpl02 implements UserService{
    @Override
    public String show () {
        return "UserService02 show";
    }
}
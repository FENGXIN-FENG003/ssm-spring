package com.fengxin.ioc_03;

import org.springframework.stereotype.Service;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
@Service
public class UserServiceImpl_01 implements UserService{
    @Override
    public String show () {
        return "UserService01 show";
    }
}

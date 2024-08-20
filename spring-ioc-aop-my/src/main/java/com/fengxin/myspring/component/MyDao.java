package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Repository;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description
 **/
@Repository
public class MyDao {
    public void printDao() {
        System.out.println("MyDao");
    }
}

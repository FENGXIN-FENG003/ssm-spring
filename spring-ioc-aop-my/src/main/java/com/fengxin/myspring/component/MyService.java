package com.fengxin.myspring.component;

import com.fengxin.myspring.annotation.Autowired;
import com.fengxin.myspring.annotation.Scope;
import com.fengxin.myspring.annotation.Service;

/**
 * @author FENGXIN
 * @date 2024/8/19
 * @project ssm-spring
 * @description
 **/
@Service(value = "service")
@Scope(value = "prototype")
public class MyService {
    
    @Autowired
    private MyDao myDao;
    
    public void printService() {
        System.out.println("MyService");
        System.out.println ("即将调用myDao-------");
        myDao.printDao ();
    }
}

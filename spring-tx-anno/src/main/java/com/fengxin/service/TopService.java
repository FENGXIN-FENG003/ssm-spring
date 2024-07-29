package com.fengxin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author FENGXIN
 * @date 2024/7/29
 * 事务传播行为 父
 **/
@Service
public class TopService {
    @Autowired
    private StudentService studentService;
    
    @Transactional
    public void  topService(){
        studentService.changeAge();
        studentService.changeName();
    }
}

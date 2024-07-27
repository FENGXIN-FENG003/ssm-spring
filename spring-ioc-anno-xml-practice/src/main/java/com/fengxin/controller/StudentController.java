package com.fengxin.controller;

import com.fengxin.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
@Controller
public class StudentController {
    @Autowired
    private StudentService service;
    public void queryAll(){
        System.out.println (service.queryAll ());
    }
}

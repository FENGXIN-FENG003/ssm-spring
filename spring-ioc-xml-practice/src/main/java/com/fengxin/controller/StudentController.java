package com.fengxin.controller;

import com.fengxin.pojo.Student;
import com.fengxin.service.StudentService;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/25
 * 控制层 输出数据
 **/
public class StudentController {
    private StudentService service;
    
    public void setService (StudentService service) {
        this.service = service;
    }
    public void queryAll(){
        List<Student> students = service.queryAll ();
        System.out.println (students);
    }
}

package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import com.fengxin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
@Service
public class StudentServiceImpl implements StudentService{
    @Autowired
    private StudentDao dao;
    @Override
    public List<Student> queryAll () {
        return dao.queryAll ();
    }
}

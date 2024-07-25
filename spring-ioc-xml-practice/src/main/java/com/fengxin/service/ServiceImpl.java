package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import com.fengxin.pojo.Student;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/25
 * 业务层 通过dao获取数据
 **/
public class ServiceImpl implements StudentService{
    private StudentDao studentDao;
    
    public void setStudentDao (StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @Override
    public List<Student> queryAll () {
        List<Student> students = studentDao.queryAll ();
        return students;
    }
}

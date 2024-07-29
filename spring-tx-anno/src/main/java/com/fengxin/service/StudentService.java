package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@Service
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    
    public void changeInfo(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}

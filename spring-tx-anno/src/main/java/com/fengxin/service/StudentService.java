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
    
    public void changeInfo01(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
    public void changeInfo02(){
        studentDao.updateAgeById(200,2);
        // 测试事物回滚
        int i = 1 / 0;
        System.out.println("-----------");
        studentDao.updateNameById("test2",2);
    }
}

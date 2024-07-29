package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@Service
@Transactional
public class StudentService {
    @Autowired
    private StudentDao studentDao;
    
    public void changeInfo01(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
    @Transactional
    public void changeInfo02(){
        studentDao.updateAgeById(200,2);
        // 测试事物回滚
        int i = 1 / 0;
        System.out.println("-----------");
        studentDao.updateNameById("test2",2);
    }
    @Transactional(readOnly = true)
    public void changeInfo03(){
        studentDao.updateAgeById(100,1);
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
    @Transactional(timeout = 1)
    public void changeInfo04(){
        studentDao.updateAgeById(100,1);
        try {
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            throw new RuntimeException (e);
        }
        System.out.println("-----------");
        studentDao.updateNameById("test1",1);
    }
}

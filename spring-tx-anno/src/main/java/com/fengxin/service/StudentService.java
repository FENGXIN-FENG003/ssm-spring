package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author FENGXIN
 * @date 2024/7/29
 * 1. 只读模式
 *      事务默认非只读 boolean readOnly() default false;
 *      一般将事务加在类上
 *      如果有方法只做查询 则覆盖事务 提高查询效率
 * 2. 超时时间
 *      默认 -1 不限定时间
 *      设置@Transactional(timeout = 整秒数) 超时回滚事务释放资源 异常信息
 *      如果在了类上设置超时 方法设置@Transactional但没有超时 则不会生效（方法覆盖了类的注解）
 * 3. 事务异常
 *      默认只针对运行时异常回滚，编译时异常不回滚
 *      可以指定异常使所有异常都回滚 防止有漏网之鱼的异常导致数据也提交
 *      rollbackFor属性：指定哪些异常类才会回滚
 *      noRollbackFor属性：指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内
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
    @Transactional(rollbackFor = Exception.class)
    public void changeInfo05() throws FileNotFoundException {
        studentDao.updateAgeById(99,1);
        // 指定异常后 回滚 数据修改不会生效
        new FileInputStream ("ssss");
        System.out.println("-----------");
        studentDao.updateNameById("test9",1);
    }
}

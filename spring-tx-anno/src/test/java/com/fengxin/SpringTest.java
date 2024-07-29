package com.fengxin;

import com.fengxin.config.StudentConfig;
import com.fengxin.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@SpringJUnitConfig(StudentConfig.class)
public class SpringTest {
    @Autowired
    private StudentService studentService;
    /**
     * 测试方法
     */
    @Test
    public void  test01(){
        studentService.changeInfo01 ();
    }
    
    /**
     * 测试事物回滚
     */
    @Test
    public void  test02(){
        studentService.changeInfo02 ();
    }
    /**
     * 测试readOnly Connection is read-only
     */
    @Test
    public void test03(){
        studentService.changeInfo03 ();
    }
    /**
     * 测试timeout TransactionTimedOutException
     */
    @Test
    public void Test04(){
        studentService.changeInfo04 ();
    }
}

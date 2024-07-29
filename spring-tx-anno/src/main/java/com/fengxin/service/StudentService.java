package com.fengxin.service;

import com.fengxin.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author FENGXIN
 * @date 2024/7/29
 * 1. 只读模式<br>
 *      事务默认非只读 boolean readOnly() default false;<br>
 *      一般将事务加在类上<br>
 *      如果有方法只做查询 则覆盖事务 提高查询效率<br>
 * 2. 超时时间<br>
 *      默认 -1 不限定时间<br>
 *      设置@Transactional(timeout = 整秒数) 超时回滚事务释放资源 异常信息<br>
 *      如果在了类上设置超时 方法设置@Transactional但没有超时 则不会生效（方法覆盖了类的注解）<br>
 * 3. 事务异常<br>
 *      默认只针对运行时异常回滚，编译时异常不回滚<br>
 *      可以指定异常使所有异常都回滚 防止有漏网之鱼的异常导致数据也提交<br>
 *      rollbackFor属性：指定哪些异常类才会回滚<br>
 *      noRollbackFor属性：指定哪些异常不会回滚, 默认没有指定,如果指定,应该在rollbackFor的范围内<br>
 * 4. 事务隔离级别<br>
 *      数据库事务的隔离级别是指在多个事务并发执行时，数据库系统为了保证数据一致性所遵循的规定。常见的隔离级别包括：<br>
 *      1. 读未提交（Read Uncommitted）：事务可以读取未被提交的数据，容易产生脏读、不可重复读和幻读等问题。实现简单但不太安全，一般不用。<br>
 *      2. 读已提交（Read Committed）：事务只能读取已经提交的数据，可以避免脏读问题，但可能引发不可重复读和幻读。<br>
 *      3. 可重复读（Repeatable Read）：在一个事务中，相同的查询将返回相同的结果集，不管其他事务对数据做了什么修改。可以避免脏读和不可重复读，但仍有幻读的问题。<br>
 *      4. 串行化（Serializable）：最高的隔离级别，完全禁止了并发，只允许一个事务执行完毕之后才能执行另一个事务。可以避免以上所有问题，但效率较低，不适用于高并发场景。<br>
 *      isolation = 设置事务的隔离级别,mysql默认是repeatable read!<br>
 * 5. 事务传播行为<br>
 *      REQUIRED 默认值 推荐 如果父方法有事务，就加入，如果没有就新建自己独立<br>
 *      REQUIRES_NEW   不管父方法是否有事务，我都新建事务，都是独立的<br>
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
    /**
     * 设置事务异常和隔离级别
     */
    
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.READ_COMMITTED)
    public void changeInfo05() throws FileNotFoundException {
        studentDao.updateAgeById(99,1);
        // 指定异常后 回滚 数据修改不会生效
        new FileInputStream ("ssss");
        System.out.println("-----------");
        studentDao.updateNameById("test9",1);
    }
    /**
     * 声明两个独立修改数据库的事务业务方法 子
     */
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeAge(){
        studentDao.updateAgeById(99,1);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void changeName(){
        studentDao.updateNameById("test2",1);
        // 默认值 加入父事务 则报错后父子事务都会回滚 数据不会提交 如果是REQUIRED_NEW 独立互不影响 未报错的事务提交数据修改
        int i = 1/0;
    }
}

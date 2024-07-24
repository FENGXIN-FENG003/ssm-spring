package com.fengxin.spring;

import com.fengxin.pojo.Student;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;


/**
 * @author FENGXIN
 * @date 2024/7/24
 **/
public class TestForJDBC {
    /**
     * 插入语句测试
     */
    @Test
    public void addSingleTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-ioc.xml");
        
        JdbcTemplate jdbcTemplate = applicationContext.getBean (JdbcTemplate.class);
        String sql = "insert into student(name,gender,age,class) values(?,?,?,?);";
        int rows = jdbcTemplate.update (sql,"枫","男",18,"高三一班");
        System.out.println ("rows = " + rows);
    }
    
    /**
     * 查询单条实体对象
     */
    @Test
    public void querySingleTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-ioc.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean (JdbcTemplate.class);
        String sql = "select id , name , age , gender , class as classes from student where id = ? ;";
        Student student = jdbcTemplate.queryForObject (sql , (rs , rowNum) -> {
            // 自己处理结果映射
            Student student1 = new Student ();
            student1.setId (rs.getInt ("id"));
            student1.setName (rs.getString ("name"));
            student1.setAge (rs.getInt ("age"));
            student1.setGender (rs.getString ("gender"));
            student1.setClasses (rs.getString ("classes"));
            return student1;
        } , 9);
        System.out.println (student);
    }
    
    /**
     * 查询实体类集合
     */
    @Test
    public void queryTest(){
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext ("spring-ioc.xml");
        JdbcTemplate jdbcTemplate = applicationContext.getBean (JdbcTemplate.class);
        String sql = "select * from student;";
        /*
        query可以返回集合!
        BeanPropertyRowMapper就是封装好RowMapper的实现,要求属性名和列名相同即可
        */
         List<Student> list = jdbcTemplate.query (sql, new BeanPropertyRowMapper<>(Student.class));
        System.out.println (list);
    }
}

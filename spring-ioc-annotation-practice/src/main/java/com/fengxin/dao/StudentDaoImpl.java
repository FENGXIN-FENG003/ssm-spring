package com.fengxin.dao;

import com.fengxin.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/26
 **/
@Repository
public class StudentDaoImpl implements StudentDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public List<Student> queryAll () {
        return jdbcTemplate.query ("select id , name , age , gender , class as classes from student ;" , new BeanPropertyRowMapper<> (Student.class));
    }
}

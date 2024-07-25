package com.fengxin.dao;

import com.fengxin.pojo.Student;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/25
 * dao层 通过jdbcTemplate获取数据
 **/
public class DaoImpl implements StudentDao{
    private JdbcTemplate jdbcTemplate;
    
    public void setJdbcTemplate (JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    
    @Override
    public List<Student> queryAll () {
        String sql = "select * from student";
        List<Student> query = jdbcTemplate.query (sql , new BeanPropertyRowMapper<> (Student.class));
        return query;
    }
}

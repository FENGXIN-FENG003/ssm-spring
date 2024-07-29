package com.fengxin.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author FENGXIN
 * @date 2024/7/29
 **/
@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public void updateNameById(String name,Integer id){
        String sql = "update student set name = ? where id = ? ;";
        int rows = jdbcTemplate.update(sql, name, id);
    }
    
    public void updateAgeById(Integer age,Integer id){
        String sql = "update student set age = ? where id = ? ;";
        jdbcTemplate.update(sql,age,id);
    }
}

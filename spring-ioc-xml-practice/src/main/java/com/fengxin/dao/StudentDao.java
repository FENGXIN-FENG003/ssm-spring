package com.fengxin.dao;

import com.fengxin.pojo.Student;

import java.util.List;

/**
 * @author FENGXIN
 * @date 2024/7/25
 **/
public interface StudentDao {
    List<Student> queryAll();
}

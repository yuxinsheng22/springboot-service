package com.madhouse.service;

import com.madhouse.entity.Student;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020/6/19 17:17
 */
public interface IStudentService {

    void add(Student student);

    Student findById(Long id);
}

package com.madhouse.service.impl;

import com.madhouse.entity.Student;
import com.madhouse.mapper.StudentMapper;
import com.madhouse.service.IStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020/6/19 17:17
 */
@Service
public class StudentServiceImpl implements IStudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public void add(Student student) {
        this.studentMapper.insert(student);
    }

    @Override
    public Student findById(Long id) {
        return this.studentMapper.selectByPrimaryKey(id);
    }


}

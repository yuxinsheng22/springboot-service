package com.madhouse.service;

import com.alibaba.fastjson.JSON;
import com.madhouse.entity.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020/6/19 17:22
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class StudentServiceTest {

    @Autowired
    private IStudentService studentService;

    @Test
    public void add() {
        Student student = new Student(100, "小明", 18);
        this.studentService.add(student);
    }

    @Test
    public void findById() {
        Long id = 1L;
        Student student = this.studentService.findById(id);
        System.out.println(JSON.toJSONString(student));
    }
}

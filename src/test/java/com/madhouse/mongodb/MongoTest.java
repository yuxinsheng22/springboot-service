package com.madhouse.mongodb;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-03 14:44
 */
@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class MongoTest {
    @Autowired
    private MongodbService mongodbService;

    @Test
    public void saveUser() {
        MongoUser user = new MongoUser("小明", 18, "男", "124535352");
        this.mongodbService.saveUser(user);
    }

    @Test
    public void saveUser1() {
        MongoUser user = new MongoUser(2L, "Uzi", 18, "男", "175903040330");
        this.mongodbService.saveUser(user);
    }

    @Test
    public void saveStudent() {
        Student student = new Student(1L, "张三", "S-001", 15);
        this.mongodbService.saveStudent(student);
    }

    @Test
    public void findUserById() {
        Long id = 1L;
        MongoUser user = this.mongodbService.findById(id);
        System.out.println(JSON.toJSONString(user));
    }

    @Test
    public void findByInIds() {
        List<Long> ids = Lists.newArrayList(1L,2L,3L);
        List<MongoUser> users = this.mongodbService.findByInIds(ids);
        System.out.println(JSON.toJSONString(users));
    }


}

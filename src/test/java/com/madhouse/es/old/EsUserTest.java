package com.madhouse.es.old;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-01 16:19
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsUserTest {

    @Autowired
    private EsUserService userService;

    @Test
    public void insert() {
//        EsUser user = new EsUser("小明", 20, "学习", "小明是个聪明的孩子", 99.5F);
        EsUser user = new EsUser("小张", 21, "打篮球", "小张是体育天才", 60F);
        user.setLocalCreatedAt(System.currentTimeMillis());
        this.userService.insert(user);
    }

    @Test
    public void update() {
        try {
            this.userService.update();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void insertOrUpdate() {
    }

    @Test
    public void findByParams() throws IOException {
        List<EsUser> list = this.userService.findByParams();
        System.out.println(new Gson().toJson(list));
    }

    @Test
    public void testUpsert(){
        this.userService.upsert();
    }


}

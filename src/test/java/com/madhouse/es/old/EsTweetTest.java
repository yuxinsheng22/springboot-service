package com.madhouse.es.old;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-08 17:28
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTweetTest {

    @Autowired
    private EsTweetService esTweetService;

    @Test
    public void findById() {
        String id = "SvUUBnEBHWbCyILsw4Dc";
        EsTweet tweet = this.esTweetService.findById(id);
        if (Objects.nonNull(tweet)) {
            System.out.println(tweet);
        } else {
            System.out.println("tweet is null");
        }
    }
}

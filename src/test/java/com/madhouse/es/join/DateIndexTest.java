package com.madhouse.es.join;

import com.madhouse.es.join.model.DateIndex;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-05-18 10:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class DateIndexTest {

    @Autowired
    private DateIndexService dateIndexService;

    @Test
    public void add() {
        DateIndex date = new DateIndex("小明", System.currentTimeMillis());
        this.dateIndexService.addClass(date);
    }
}

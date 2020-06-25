package com.madhouse.redis;

import com.madhouse.redis.command.RedisZsetCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 15:42
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisZsetCommandTest {

    private static final String ZSET_TEST_REDIS_KEY_FREFIX = "zset:test:";
    private static final String KEY1 = ZSET_TEST_REDIS_KEY_FREFIX + "1";
    private static final String KEY2 = ZSET_TEST_REDIS_KEY_FREFIX + "2";
    private static final String KEY3 = ZSET_TEST_REDIS_KEY_FREFIX + "3";

    @Autowired
    private RedisZsetCommand redisZsetCommand;

    @Test
    public void add() {
        this.redisZsetCommand.add(KEY1, 80, 17D);
        this.redisZsetCommand.add(KEY1, 76, 77D);
        this.redisZsetCommand.add(KEY1, 28, 56D);
    }

    @Test
    public void removeRange() {
        System.out.println(this.redisZsetCommand.removeRange(KEY1, 0L, 1L));
    }

    @Test
    public void removeRangeByScore() {
        System.out.println(this.redisZsetCommand.removeRangeByScore(KEY1, 17D, 18D));
    }

    @Test
    public void count() {
        System.out.println(this.redisZsetCommand.count(KEY1, 18D, 56D));
    }

    @Test
    public void rank() {
        System.out.println(this.redisZsetCommand.rank(KEY1, 15));
    }

    @Test
    public void reverseRank() {
        System.out.println(this.redisZsetCommand.reverseRank(KEY1, 15));
    }

    @Test
    public void zCard() {
        System.out.println(this.redisZsetCommand.zCard(KEY1));
    }


    @Test
    public void score() {
        System.out.println(this.redisZsetCommand.score(KEY1,15));
    }

}

package com.madhouse.redis;

import com.google.common.collect.Maps;
import com.madhouse.redis.command.RedisHashCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 16:32
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisHashCommandTest {

    private static final String HASH_TEST_REDIS_KEY_FREFIX = "hash:test:";
    private static final String KEY1 = HASH_TEST_REDIS_KEY_FREFIX + "1";

    @Autowired
    private RedisHashCommand redisHashCommand;

    @Test
    public void put() {
        Map<String, Integer> map = Maps.newHashMap();
        map.put("a", 1);
        map.put("b", 2);
        map.put("c", 3);
        this.redisHashCommand.putAll(KEY1, map);
    }

    @Test
    public void entries() {
        System.out.println(this.redisHashCommand.entries(KEY1));
    }

    @Test
    public void size() {
        System.out.println(this.redisHashCommand.size(KEY1));
    }


}

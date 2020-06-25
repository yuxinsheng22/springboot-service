package com.madhouse.redis;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.madhouse.redis.command.RedisCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-16 14:31
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisCommandTest {

    private static final String TEST_REDIS_KEY_FREFIX = "command:test:";
    private static final String LIST_TEST_REDIS_KEY_FREFIX = "list:test:";


    @Autowired
    private RedisCommand redisCommand;

    @Test
    public void keys() {
        System.out.println(redisCommand.keys("*test*"));
    }


    @Test
    public void dbSize() {
        System.out.println(redisCommand.dbSize());
    }

    @Test
    public void set() {
        String key = "HH:test:key:1";
        String value = "1";
        this.redisCommand.set(key, value);
    }


    @Test
    public void get() {
        String key = TEST_REDIS_KEY_FREFIX + "1";
        System.out.println(this.redisCommand.get(key));
    }

    @Test
    public void getSet() {
        String key = TEST_REDIS_KEY_FREFIX + "1";
        String value = "getSet";
        this.redisCommand.getSet(key, value);
    }


    @Test
    public void mget() {
        String key1 = TEST_REDIS_KEY_FREFIX + "1";
        String key2 = TEST_REDIS_KEY_FREFIX + "2";
        List<String> keys = Lists.newArrayList(key1, key2);
        System.out.println(JSON.toJSONString(this.redisCommand.mget(keys)));
    }

    @Test
    public void setIfAbsent() {
        String key1 = TEST_REDIS_KEY_FREFIX + "1";
        String value = "1";
        System.out.println(this.redisCommand.setIfAbsent(key1, value));
    }

    @Test
    public void setIfPresent() {
        String key1 = TEST_REDIS_KEY_FREFIX + "1";
        String value = "1";
        System.out.println(this.redisCommand.setIfPresent(key1, value));
    }

    @Test
    public void mset() {
        String key3 = TEST_REDIS_KEY_FREFIX + "3";
        String value3 = "3";
        String key4 = TEST_REDIS_KEY_FREFIX + "4";
        String value4 = "4";
        Map<String, String> map = Maps.newHashMap();
        map.put(key3, value3);
        map.put(key4, value4);
        this.redisCommand.mset(map);
    }

    @Test
    public void append() {
        String key4 = TEST_REDIS_KEY_FREFIX + "4";
        String value4 = "append";
        this.redisCommand.append(key4, value4);
    }

    //list test

    @Test
    public void rpush() {
        String key1 = LIST_TEST_REDIS_KEY_FREFIX + "1";
        this.redisCommand.rightPush(key1, 100);
    }

    @Test
    public void rpush2() {
        String key1 = LIST_TEST_REDIS_KEY_FREFIX + "1";
        this.redisCommand.rightPush(key1, 1, 4);
    }

    @Test
    public void rpushAll() {
        String key = LIST_TEST_REDIS_KEY_FREFIX + "2";
        Integer[] values = {4, 4, 5};
        this.redisCommand.rightPushAll(key, values);
    }

    @Test
    public void listSize() {
        String key = LIST_TEST_REDIS_KEY_FREFIX + "2";
        this.redisCommand.listSize(key);
    }

    @Test
    public void range() {
        String key = LIST_TEST_REDIS_KEY_FREFIX + "2";
        System.out.println(this.redisCommand.range(key, 0L, 1L));
    }

    @Test
    public void indexSetValue() {
        String key = LIST_TEST_REDIS_KEY_FREFIX + "2";
        this.redisCommand.indexSetValue(key, 2L, 4);
    }


    @Test
    public void remove() {
        String key = LIST_TEST_REDIS_KEY_FREFIX + "2";
        this.redisCommand.remove(key, 0L, 4);
    }

    @Test
    public void rightPopAndLeftPush() {
        String key1 = LIST_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = LIST_TEST_REDIS_KEY_FREFIX + "2";
        System.out.println(this.redisCommand.rightPopAndLeftPush(key1, key2));

    }

}

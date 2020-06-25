package com.madhouse.redis;

import com.google.common.collect.Lists;
import com.madhouse.redis.command.RedisSetCommand;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:21
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class RedisSetCommandTest {

    private static final String SET_TEST_REDIS_KEY_FREFIX = "set:test:";

    @Autowired
    private RedisSetCommand redisSetCommand;

//set test

    @Test
    public void add() {
        String key = SET_TEST_REDIS_KEY_FREFIX + "2";
        this.redisSetCommand.add(key, new Integer[]{2, 3, 5, 8});
    }

    @Test
    public void add1() {
        String key = SET_TEST_REDIS_KEY_FREFIX + "String1";
        this.redisSetCommand.add(key, new String[]{"abc", "add", "23", "hd"});
    }

    @Test
    public void union() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = SET_TEST_REDIS_KEY_FREFIX + "2";
        System.out.println(this.redisSetCommand.union(key1, key2));
    }

    @Test
    public void unionAndStore() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = SET_TEST_REDIS_KEY_FREFIX + "2";
        String key3 = SET_TEST_REDIS_KEY_FREFIX + "3";
        System.out.println(this.redisSetCommand.unionAndStore(key1, key2, key3));
    }

    @Test
    public void intersectByKeys() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = SET_TEST_REDIS_KEY_FREFIX + "2";
        String key3 = SET_TEST_REDIS_KEY_FREFIX + "3";
        System.out.println(this.redisSetCommand.intersectByKeys(Lists.newArrayList(key1, key2, key3)));
    }

    @Test
    public void difference() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = SET_TEST_REDIS_KEY_FREFIX + "2";
        System.out.println(this.redisSetCommand.difference(key1, key2));
    }

    @Test
    public void differenceAndStore() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        String key2 = SET_TEST_REDIS_KEY_FREFIX + "2";
        String key4 = SET_TEST_REDIS_KEY_FREFIX + "4";
        System.out.println(this.redisSetCommand.differenceAndStore(key1, key2, key4));
    }

    @Test
    public void isMember() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        System.out.println(this.redisSetCommand.isMember(key1, 1));
    }

    @Test
    public void members() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "1";
        System.out.println(this.redisSetCommand.members(key1));
    }

    @Test
    public void scan() {
        String key1 = SET_TEST_REDIS_KEY_FREFIX + "String1";
        this.redisSetCommand.scan(key1);
    }
}

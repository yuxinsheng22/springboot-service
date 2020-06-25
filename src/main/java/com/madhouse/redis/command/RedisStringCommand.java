package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:09
 */
@Component
public class RedisStringCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 取出key对象的值,重置成value
     */
    public void getSet(String key, String value) {
        this.redisTemplate.opsForValue().getAndSet(key, value);
    }

    public List<Object> mget(List<String> keys) {
        return this.redisTemplate.opsForValue().multiGet(keys);
    }


    /**
     * 如果key不存在才去set
     */
    public Boolean setIfAbsent(String key, String value) {
        return this.redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 如果key存在才去set
     */
    public Boolean setIfPresent(String key, String value) {
        return this.redisTemplate.opsForValue().setIfPresent(key, value);
    }

    /**
     * 同时设置多个key,value
     */
    public void mset(Map<String, String> map) {
        this.redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 每次key对应的value增加1
     */
    public void increment(String key) {
        this.redisTemplate.opsForValue().increment(key);
    }

    /**
     * 每次key对应的value增加value
     */
    public void incrementBy(String key, long value) {
        this.redisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 每次key对应的value减小1
     */
    public void decrement(String key) {
        this.redisTemplate.opsForValue().decrement(key);
    }

    /**
     * 每次key对应的value减小value
     */
    public void decrementBy(String key, long value) {
        this.redisTemplate.opsForValue().decrement(key, value);
    }

    /**
     * key对应的值,字符串拼接value
     */
    public void append(String key, String value) {
        this.redisTemplate.opsForValue().append(key, value);
    }

}

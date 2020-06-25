package com.madhouse.redis;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-14 15:01
 */
@Slf4j
@Component
public class RedisLock {

    private static final String KEY = "lock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    public void setEx() {
        String key = "lock";
        this.stringRedisTemplate.opsForValue().set(key, "test", 200, TimeUnit.SECONDS);
    }

    public Boolean setNx() {
        return this.stringRedisTemplate.opsForValue().setIfAbsent(KEY, "test");
    }

    public Boolean setNx2(String key) {
        return this.stringRedisTemplate.opsForValue().setIfAbsent(key, "haha", 300, TimeUnit.SECONDS);
    }

    public Boolean tryLock(String key){
        return this.stringRedisTemplate.opsForValue().setIfAbsent(key, "lock", 300, TimeUnit.SECONDS);
    }

    public void unlock(String key) {
        this.stringRedisTemplate.delete(key);
    }

}

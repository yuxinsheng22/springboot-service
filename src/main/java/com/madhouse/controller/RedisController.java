package com.madhouse.controller;

import com.madhouse.redis.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-14 15:57
 */
@Slf4j
@RestController
public class RedisController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisLock redisLock;

    @RequestMapping(value = "api/springboot_demo/redis/test")
    public String lock() {
        this.redisLock.setEx();
        return "success";
    }

    @RequestMapping(value = "api/springboot_demo/redis/set_nx")
    public String setNx() {
        boolean flag = this.redisLock.setNx();
        return String.valueOf(flag);
    }

    @RequestMapping(value = "api/springboot_demo/redis/set_nx2")
    public String setNx2(String key) {
        boolean flag = this.redisLock.setNx2(key);
        return String.valueOf(flag);
    }

    @RequestMapping(value = "api/springboot_demo/redis/concurrent_lock")
    public void testRedisConcurrentLock(String key) {
        int threadNum = 20;
        final ExecutorService pool = newFixedThreadPool(threadNum);
        for (int i = 0; i < threadNum; i++) {
            pool.execute(() -> {
                Boolean flag = this.stringRedisTemplate.opsForValue().setIfAbsent(key, "test concurrent lock", 300, TimeUnit.SECONDS);
                assert flag != null;
                if (flag) {
                    log.info("get lock");
                } else {
                    log.info("can not get lock");
                }
            });
        }
    }
}

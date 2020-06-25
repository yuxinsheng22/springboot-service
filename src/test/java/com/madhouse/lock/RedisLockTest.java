package com.madhouse.lock;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-14 15:12
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisLockTest {

    private static final String KEY = "redis_lock";

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void tryLock() {
        final ExecutorService pool = newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            pool.execute(() -> {
                boolean lock = this.stringRedisTemplate.opsForValue().setIfAbsent(KEY, "lock test", 200, TimeUnit.SECONDS);
                if (lock) {
                    log.info("get lock");
                } else {
                    log.info("unlock");
                }
            });
        }
    }

}

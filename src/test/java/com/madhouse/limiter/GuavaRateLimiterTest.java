package com.madhouse.limiter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-11 10:57
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GuavaRateLimiterTest {

    @Autowired
    private GuavaRateLimiter guavaRateLimiter;

    @Autowired
    private ThreadPoolTaskExecutor threadPoolTaskExecutor;

    @Test
    public void test() {
        for (int i = 0; i < 10; i++) {
            threadPoolTaskExecutor.execute(() -> guavaRateLimiter.test());
        }
    }

}

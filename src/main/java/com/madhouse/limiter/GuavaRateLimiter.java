package com.madhouse.limiter;

import com.google.common.util.concurrent.RateLimiter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-11 10:21
 */
@Slf4j
@Service
public class GuavaRateLimiter {

    private final RateLimiter rateLimiter = RateLimiter.create(2);

    private boolean tryAcquire() {
        return rateLimiter.tryAcquire();
    }

    public void test() {
        if (this.tryAcquire()) {
            log.info("获取到令牌");
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                log.error("阻塞异常", e);
            }
        } else {
            log.info("无法获得令牌");
        }
    }

}

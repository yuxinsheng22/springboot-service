package com.madhouse.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-01 11:28
 */
@Slf4j
@Service
public class RetryServiceImpl implements RetryService {

    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000, multiplier = 1.5))
    @Override
    public Integer retry(Integer num) throws Exception {
        log.info("num[{}]", num);
        if (num < 100) {
            throw new Exception("数字小于100");
        }
        return num;
    }
}

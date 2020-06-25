package com.madhouse.retry;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc: 测试spring的重试机制
 * @author: yuxinsheng
 * @date: 2020-04-01 11:25
 */
@Slf4j
@RestController
public class RetryController {

    @Autowired
    private RetryService retryService;

    @RequestMapping(value = "api/springboot_demo/test/retry")
    public Integer retry(Integer num) {
        Integer result = 0;
        try {
            result = this.retryService.retry(num);
            return result;
        } catch (Exception e) {
            log.info("什么时候进来");
        }
        return result;
    }
}

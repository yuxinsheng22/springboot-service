package com.madhouse.retry;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-01 11:25
 */
public interface RetryService {
    Integer retry(Integer num) throws Exception;

}

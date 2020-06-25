package com.madhouse.controller;

import com.madhouse.common.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-15 14:44
 */
@Slf4j
@RestController
public class AopController {

    @RequestMapping(value = "api/spring_demo/aop/test")
    public ApiResponse test() {
        int a = 1 / 0;
        return new ApiResponse();
    }
}

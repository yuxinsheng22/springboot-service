package com.madhouse.aop;

import com.madhouse.common.ApiResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-15 14:30
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
public class GlobalExceptionHandler {

    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ApiResponse handleException(Exception e) {
        if (e instanceof NullPointerException) {
            NullPointerException exception = (NullPointerException) e;
            return new ApiResponse(null, 501, "null point ex:" + exception.getMessage());
        } else if (e instanceof ArithmeticException) {
            ArithmeticException exception = (ArithmeticException) e;
            return new ApiResponse(null, 502, "ex:" + exception.getMessage());
        }
        return new ApiResponse(null, 500, "unknown error");
    }
}

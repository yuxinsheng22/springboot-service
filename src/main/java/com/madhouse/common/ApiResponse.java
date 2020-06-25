package com.madhouse.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-15 14:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiResponse<T> {
    private T data;

    private int code;

    private String message;

}

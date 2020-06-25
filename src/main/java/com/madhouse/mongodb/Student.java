package com.madhouse.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-03 15:52
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    private Long id;

    private String name;

    private String no;

    private Integer age;
}

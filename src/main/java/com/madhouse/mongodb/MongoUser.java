package com.madhouse.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-03 14:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MongoUser {

    private Long id;

    private String name;

    private Integer age;

    private String gender;

    private String phone;

    public MongoUser(String name, Integer age, String gender, String phone) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
    }
}

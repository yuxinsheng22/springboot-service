package com.madhouse.es.join.model;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-05-18 10:27
 */
@Data
public class DateIndex {

    private String name;

    private Long birthday;

    public DateIndex() {
    }

    public DateIndex(String name, Long birthday) {
        this.name = name;
        this.birthday = birthday;
    }
}

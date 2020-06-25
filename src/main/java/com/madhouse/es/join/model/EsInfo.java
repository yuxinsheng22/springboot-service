package com.madhouse.es.join.model;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 14:26
 */
@Data
public class EsInfo {

    private String name;

    private String parent;

    public EsInfo() {
    }

    public EsInfo(String name) {
        this.name = name;
    }

    public EsInfo(String name, String parent) {
        this.name = name;
        this.parent = parent;
    }
}

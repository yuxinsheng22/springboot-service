package com.madhouse.es.join.model;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 14:12
 */
@Data
public class EsClass {

    private String id;

    private String classNo;

    private String className;

    private String classDesc;

    private EsInfo info;

    public EsClass() {
    }

    public EsClass(String classNo, String className, String classDesc, EsInfo info) {
        this.classNo = classNo;
        this.className = className;
        this.classDesc = classDesc;
        this.info = info;
    }
}

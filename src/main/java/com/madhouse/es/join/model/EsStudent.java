package com.madhouse.es.join.model;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 14:12
 */
@Data
public class EsStudent {

    private String id;

    private String studentNo;

    private String studentName;

    private String studentDesc;

    private String studentInterest;

    private EsInfo info;

    public EsStudent() {
    }

    public EsStudent(String studentNo, String studentName, String studentDesc, String studentInterest, EsInfo info) {
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentDesc = studentDesc;
        this.studentInterest = studentInterest;
        this.info = info;
    }

    public EsStudent(String id, String studentNo, String studentName, String studentDesc, String studentInterest, EsInfo info) {
        this.id = id;
        this.studentNo = studentNo;
        this.studentName = studentName;
        this.studentDesc = studentDesc;
        this.studentInterest = studentInterest;
        this.info = info;
    }
}

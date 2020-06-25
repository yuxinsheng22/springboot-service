package com.madhouse.es.old;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-01 16:08
 */
@Data
public class EsUser {

    private String id;

    private String userName;

    private Integer userAge;

    private String interest;

    private String desc;

    private Float score;

    private Long localCreatedAt;

    public EsUser() {
    }

    public EsUser(String userName, Integer userAge, String interest, String desc, Float score) {
        this.userName = userName;
        this.userAge = userAge;
        this.interest = interest;
        this.desc = desc;
        this.score = score;
    }
}

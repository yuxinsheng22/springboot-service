package com.madhouse.es.join.model;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-16 10:04
 */
@Data
public class EsWord {

    private String id;

    private String wordText;

    private Float wordSalience;

    private EsInfo info;

    public EsWord() {
    }

    public EsWord(String wordText, Float wordSalience, EsInfo info) {
        this.wordText = wordText;
        this.wordSalience = wordSalience;
        this.info = info;
    }
}

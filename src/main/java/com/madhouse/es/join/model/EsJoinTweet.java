package com.madhouse.es.join.model;

import lombok.Data;
import org.joda.time.DateTime;

import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 18:00
 */
@Data
public class EsJoinTweet {

    private String id;

    private Long tweetId;

    private List<Long> tweetKeywordIds;

    private Long tweetCreateAt;

    private EsInfo info;

    public EsJoinTweet() {
    }

    public EsJoinTweet(Long tweetId, List<Long> tweetKeywordIds, EsInfo info) {
        this.tweetId = tweetId;
        this.tweetKeywordIds = tweetKeywordIds;
        this.tweetCreateAt = new DateTime().withTimeAtStartOfDay().getMillis();
        this.info = info;
    }
}

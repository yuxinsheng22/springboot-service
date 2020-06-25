package com.madhouse.es.old;

import lombok.Data;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-08 16:23
 */
@Data
public class EsTweet {

    /**
     * 索引id
     */
    private String id;

    /**
     * 推文id
     */
    private String tweetId;

    /**
     * 推文文案
     */
    private String text;

    /**
     * 推文语言
     */
    private String lang;

    /**
     * 发推时开始定位的国家
     */
    private String placeCountry;

    /**
     * 推文源地址
     */
    private String expandedUrl;

    /**
     * 物料地址(多个物料半角逗号分隔)
     */
    private String mediaUrls;

    /**
     * 物料类型(文本:1,图片:2,视频:3)
     */
    private Integer mediaType;

    /**
     * 发推用户id
     */
    private Long twUserId;

    /**
     * 评论数
     */
    private Integer replyCnt;

    /**
     * 引用数
     */
    private Integer quoteCnt;

    /**
     * 转发数
     */
    private Integer retweetCnt;

    /**
     * 点赞数
     */
    private Integer favoriteCnt;

    /**
     * 分享数(引用数+转发数)
     */
    private Integer shareCnt;

    /**
     * 热度指数(引用数+转发数+评论数+点赞数)
     */
    private Integer heatCnt;

    /**
     * 分值
     */
    private Float score;

    /**
     * 情感值
     */
    private Float magnitude;

    /**
     * 发推时间
     */
    private Long tweetCreatedAt;

    /**
     * 发推日期
     */
    private Long tweetCreatedDay;

    /**
     * 记录入库时间
     */
    private Long localCreatedAt;

    /**
     * 记录更新时间
     */
    private Long localUpdatedAt;

    public EsTweet() {
    }
}

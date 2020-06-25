package com.madhouse.es.join;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.madhouse.es.join.model.EsJoinTweet;
import com.madhouse.es.join.model.EsWord;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-16 10:08
 */
@Slf4j
@Service
public class EsTweetWordService {

    private static final String INDEX = "tweet_word_index";
    private static final String TYPE = "tweet_word_type";

    @Autowired
    private RestHighLevelClient restHighLevelClient;


    public void addTweet(String id, EsJoinTweet tweet) {
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE);
        indexRequest.id(id);
        indexRequest.source(JSON.toJSONString(tweet), XContentType.JSON);
        try {
            IndexResponse response = this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入tweet 异常", e);
        }
    }


    public void addWord(String id, String routing, EsWord word) {
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE);
        indexRequest.id(id);
        indexRequest.routing(routing);
        indexRequest.source(JSON.toJSONString(word), XContentType.JSON);
        try {
            IndexResponse response = this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入word 异常", e);
        }
    }

    public EsJoinTweet getTweetById(String id) {
        GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
        try {
            GetResponse response = this.restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> map = response.getSource();
            return JSON.parseObject(JSON.toJSONString(map), EsJoinTweet.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public EsWord getWordById(String id) {
        GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
        try {
            GetResponse response = this.restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            String responseId = response.getId();
            Map<String, Object> map = response.getSource();
            map.put("id", responseId);
            return JSON.parseObject(JSON.toJSONString(map), EsWord.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void updateTweet(String id) {
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("tweetKeywordIds", Lists.newArrayList(5L, 6L));
        updateRequest.doc(map);
        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("更新tweet error,_id[" + id + "]", e);
        }
    }

    public void updateWord(String id) {
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id);
        updateRequest.routing("ff8d46f48014ff24574d813f4eccfb1b");
        Map<String, Object> map = Maps.newHashMap();
        map.put("wordSalience", 1.3F);
        updateRequest.doc(map);
        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("更新word error,_id[" + id + "]", e);
        }
    }


}

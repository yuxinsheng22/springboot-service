package com.madhouse.es.join;

import com.alibaba.fastjson.JSON;
import com.madhouse.es.join.model.DateIndex;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-05-18 10:28
 */
@Slf4j
@Service
public class DateIndexService {

    private static final String INDEX = "date_index";
    private static final String TYPE = "date_type";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void addClass(DateIndex date) {
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE);
        indexRequest.source(JSON.toJSONString(date), XContentType.JSON);
        try {
            IndexResponse response = this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入date index异常", e);
        }
    }
}

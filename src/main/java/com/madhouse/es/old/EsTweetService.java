package com.madhouse.es.old;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-08 17:19
 */
@Slf4j
@Service
public class EsTweetService {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    private static final String INDEX = "tweet_index";
    private static final String TYPE = "tweet_type";

    public EsTweet findById(String id) {
        SearchRequest request = new SearchRequest(INDEX);
        request.types(TYPE);
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.size(10);

        //查询条件设置
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();

        boolQueryBuilder.must(QueryBuilders.termQuery("_id", id));

        sourceBuilder.query(boolQueryBuilder);

        //查询条件
        request.source(sourceBuilder);
        //设置type
        SearchResponse response;
        List<EsTweet> list = Lists.newArrayList();
        try {
            //查询
            response = this.restHighLevelClient.search(request, RequestOptions.DEFAULT);
            SearchHits hits = response.getHits();
            if (hits.getTotalHits() > 0) {
                for (SearchHit hit : hits) {
                    Map<String, Object> source = hit.getSourceAsMap();
                    source.put("id", hit.getId());
                    list.add(JSON.parseObject(JSON.toJSONString(source), EsTweet.class));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (CollectionUtils.isNotEmpty(list)) {
            return list.get(0);
        }
        return null;
    }

}

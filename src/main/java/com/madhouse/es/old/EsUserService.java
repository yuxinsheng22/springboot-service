package com.madhouse.es.old;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-01 16:11
 */
@Slf4j
@Service
public class EsUserService {

    private static final String USER_INDEX = "user_index";
    private static final String USER_TYPE = "user_type";


    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void insert(EsUser user) {
        IndexRequest indexRequest = new IndexRequest(USER_INDEX, USER_TYPE);
        indexRequest.source(JSON.toJSONString(user), XContentType.JSON);
        try {

            this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入Tweet异常", e);
        }
    }

    public List<EsUser> findByParams() throws IOException {
        List<EsUser> list = Lists.newArrayList();
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        sourceBuilder.query(QueryBuilders.termQuery("userAge", 20));
        SearchRequest request = new SearchRequest(USER_INDEX);
        request.source(sourceBuilder);
        SearchResponse response = this.restHighLevelClient.search(request, RequestOptions.DEFAULT);
        if (Objects.equals(response.status(), RestStatus.OK)) {
            SearchHits hits = response.getHits();
            Gson gson = new Gson();
            hits.forEach(hit -> {
                Map<String, Object> source = hit.getSourceAsMap();
                source.put("id", hit.getId());
                list.add(gson.fromJson(gson.toJson(source), EsUser.class));
            });
        }
        return list;
    }

    public void update() throws IOException {
        List<EsUser> list = this.findByParams();
        if (CollectionUtils.isNotEmpty(list)) {
            list.forEach(user -> this.updateById(user.getId()));
        }
    }

    public void updateById(String id) {
        UpdateRequest updateRequest = new UpdateRequest(USER_INDEX, USER_TYPE, id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("interest", "爱好打游戏");
        map.put("userAge", 18);
        map.put("desc", "test upsert");
        updateRequest.doc(map);
        updateRequest.upsert(map);

        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("update es user error,id[" + id + "]", e);
        }
    }

    public void upsert() {
        String id = "abcd";
        this.updateById(id);
    }



}

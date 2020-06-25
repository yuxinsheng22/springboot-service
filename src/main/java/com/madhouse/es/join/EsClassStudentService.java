package com.madhouse.es.join;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.madhouse.es.join.model.EsClass;
import com.madhouse.es.join.model.EsStudent;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
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
 * @date: 2020-04-15 14:22
 */
@Slf4j
@Service
public class EsClassStudentService {

    private static final String INDEX = "class_student_index";
    private static final String TYPE = "class_student_type";

    @Autowired
    private RestHighLevelClient restHighLevelClient;

    public void addClass(EsClass esClass, String id) {
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE);
        indexRequest.id(id);
        indexRequest.source(JSON.toJSONString(esClass), XContentType.JSON);
        try {
            IndexResponse response = this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入parent class异常", e);
        }
    }

    public void addStudent(EsStudent student, String id, String routing) {
        IndexRequest indexRequest = new IndexRequest(INDEX, TYPE);
        indexRequest.id(id);
        indexRequest.routing(routing);
        indexRequest.source(JSON.toJSONString(student), XContentType.JSON);
        try {
            this.restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        } catch (IOException e) {
            log.error("插入child student异常", e);
        }
    }

    public void addBatchStudent(List<EsStudent> students) throws Exception {
        BulkRequest bulkRequest = new BulkRequest();
        students.forEach(student -> {
            IndexRequest indexRequest = new IndexRequest(INDEX, TYPE, student.getId());
            indexRequest.routing(student.getId());
            student.setId(null);
            indexRequest.source(JSON.toJSONString(student), XContentType.JSON);
            bulkRequest.add(indexRequest);
        });
        this.restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }

    public void findById(String id) {
        GetRequest getRequest = new GetRequest(INDEX, TYPE, id);
        try {
            GetResponse response = this.restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);
            Map<String, Object> map = response.getSource();
            System.out.println(new Gson().toJson(map));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findByStudentNo(String studentNo) {
        SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
        //构建符合查询对象
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        boolQueryBuilder.must(QueryBuilders.termQuery("studentNo", studentNo));
        //组合查询条件
        sourceBuilder.query(boolQueryBuilder);
        SearchRequest request = new SearchRequest(INDEX);
        request.source(sourceBuilder);
        try {
            SearchResponse response = this.restHighLevelClient.search(request, RequestOptions.DEFAULT);
            List<EsStudent> list = Lists.newArrayList();
            SearchHits hits = response.getHits();
            hits.forEach(hit -> {
                Map<String, Object> source = hit.getSourceAsMap();
                source.put("id", hit.getId());
                list.add(JSON.parseObject(JSON.toJSONString(source), EsStudent.class));
            });
            log.info(JSON.toJSONString(list));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateClass(String id) {
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("classDesc", "先进班级表现一般");
        updateRequest.doc(map);
        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("更新class error,_id[" + id + "]", e);
        }
    }

    public void updateStudent(String id, String studentDesc, String studentInterest) {
        UpdateRequest updateRequest = new UpdateRequest(INDEX, TYPE, id);
        Map<String, Object> map = Maps.newHashMap();
        map.put("studentDesc", studentDesc);
        map.put("studentInterest", studentInterest);
        updateRequest.doc(map);
        try {
            this.restHighLevelClient.update(updateRequest, RequestOptions.DEFAULT);
        } catch (Exception e) {
            log.error("更新student error,_id[" + id + "]", e);
        }
    }


    public void deleteDoc(String id) {
        DeleteRequest request = new DeleteRequest(INDEX, TYPE, id);
        try {
            this.restHighLevelClient.delete(request, RequestOptions.DEFAULT);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

package com.madhouse.mongodb;

import com.google.common.collect.Lists;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.CriteriaDefinition;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-03 14:40
 */
@Service
public class MongodbService {

    @Autowired
    private MongoTemplate mongoTemplate;

    /**
     * 单条增加
     *
     * @param user
     */
    public void saveUser(MongoUser user) {
        this.mongoTemplate.save(user);
    }

    public void saveStudent(Student student) {
        this.mongoTemplate.save(student);
    }

    public MongoUser findById(Long id){
        Query query= new Query(Criteria.where("id").is(id));
        return this.mongoTemplate.findOne(query,MongoUser.class);
    }

    public List<MongoUser> findByInIds(List<Long> ids){
        Query query = new Query(Criteria.where("id").in(ids));
        return this.mongoTemplate.find(query,MongoUser.class);
    }

}

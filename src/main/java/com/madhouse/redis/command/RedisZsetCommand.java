package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:10
 */
@Component
public class RedisZsetCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 往zset中添加元素,并为元素增加分数,用于排序,如果该value已经存在,那么会更新score
     */
    public void add(String key, Integer value, Double score) {
        this.redisTemplate.opsForZSet().add(key, value, score);
    }

    /**
     * 删除set中元素
     */
    public void remove(String key, List<Integer> members) {
        this.redisTemplate.opsForZSet().remove(key, members);
    }

    /**
     * 删除set中元素,排序后删除下标为from到to的元素[from,to]
     */
    public Long removeRange(String key, long from, long to) {
        return this.redisTemplate.opsForZSet().removeRange(key, from, to);
    }

    /**
     * 删除set中元素,只删除元素的score在from和to之间的元素[from,to]
     */
    public Long removeRangeByScore(String key, Double from, Double to) {
        return this.redisTemplate.opsForZSet().removeRangeByScore(key, from, to);
    }

    /**
     * 计算set中元素的score在from和to之间的元素个数
     */
    public Long count(String key, Double from, Double to) {
        return this.redisTemplate.opsForZSet().count(key, from, to);
    }

    /**
     * set元素从小到大排序后,计算member元素的index
     */
    public Long rank(String key, Integer member) {
        return this.redisTemplate.opsForZSet().rank(key, member);
    }

    /**
     * set元素从大到小排序后,计算member元素的index
     */
    public Long reverseRank(String key, Integer member) {
        return this.redisTemplate.opsForZSet().reverseRank(key, member);
    }

    /**
     * 返回zset的基数
     */
    public Long zCard(String key) {
        return this.redisTemplate.opsForZSet().zCard(key);
    }

    /**
     * 返回排序后索引from到to的元素,[from,to]
     */
    public Set<Object> range(String key, long from, long to) {
        return this.redisTemplate.opsForZSet().range(key, from, to);
    }

    /**
     * 返回排序后score在from到to的元素,[from,to]
     */
    public Set<Object> rangeByScore(String key, Double from, Double to) {
        return this.redisTemplate.opsForZSet().rangeByScore(key, from, to);
    }

    /**
     * 返回元素的score
     */
    public Double score(String key, Integer member) {
        return this.redisTemplate.opsForZSet().score(key, member);
    }
}

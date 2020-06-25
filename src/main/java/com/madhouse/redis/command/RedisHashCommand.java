package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:10
 */
@Component
public class RedisHashCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 往名为key的hash中增加hk->hv键值对
     */
    public void put(String key, String hk, Integer hv) {
        this.redisTemplate.opsForHash().put(key, hk, hv);
    }

    /**
     * 往名为key的hash中增加多组键值对
     */
    public void putAll(String key, Map<String, Integer> map) {
        this.redisTemplate.opsForHash().putAll(key, map);
    }

    /**
     * 返回key下的所有键值对
     */
    public Map<Object, Object> entries(String key) {
        return this.redisTemplate.opsForHash().entries(key);
    }

    /**
     * 返回key下hk对应的value
     */
    public Object get(String key, String hk) {
        return this.redisTemplate.opsForHash().get(key, hk);
    }

    /**
     * 返回key下所有的hk
     */
    public Set<Object> keys(String key) {
        return this.redisTemplate.opsForHash().keys(key);
    }

    /**
     * 返回key下所有的hv
     */
    public List<Object> values(String key) {
        return this.redisTemplate.opsForHash().values(key);
    }

    /**
     * 判断key下是否包含hk
     */
    public Boolean hasKey(String key, String hk) {
        return this.redisTemplate.opsForHash().hasKey(key, hk);
    }

    /**
     * 返回key下指定hks的values
     */
    public List<Object> multiGet(String key, List<Object> hks) {
        return this.redisTemplate.opsForHash().multiGet(key, hks);
    }

    /**
     * 每次调用使key下的hk对应的hv增加value
     */
    public Long increment(String key, String hk, long value) {
        return this.redisTemplate.opsForHash().increment(key, hk, value);
    }

    /**
     * 删除key下hks
     */
    public Long delete(String key, Object[] hks) {
        return this.redisTemplate.opsForHash().delete(key, hks);
    }

    /**
     * 返回key下多少键值对
     */
    public Long size(String key) {
        return this.redisTemplate.opsForHash().size(key);
    }

}

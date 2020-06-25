package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:10
 */
@Component
public class RedisSetCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * set中添加一系列member
     */
    public void add(String key, Object[] values) {
        this.redisTemplate.opsForSet().add(key, values);
    }

    /**
     * set中删除元素member
     */
    public void remove(String key, Integer value) {
        this.redisTemplate.opsForSet().remove(key, value);
    }

    /**
     * 随机删除并返回set中的一个member
     */
    public Object pop(String key) {
        return this.redisTemplate.opsForSet().pop(key);
    }

    /**
     * 将key1中set中的元素member移到名为key2的set中
     */
    public void move(String key1, Integer member, String key2) {
        this.redisTemplate.opsForSet().move(key1, member, key2);
    }

    /**
     * 取并集
     */
    public Set<Object> union(String key1, String key2) {
        return this.redisTemplate.opsForSet().union(key1, key2);
    }

    /**
     * key1和key2的并集存储到key3
     */
    public Long unionAndStore(String key1, String key2, String key3) {
        return this.redisTemplate.opsForSet().unionAndStore(key1, key2, key3);
    }

    /**
     * 取交集
     */
    public Set<Object> intersect(String key1, String key2) {
        return this.redisTemplate.opsForSet().intersect(key1, key2);
    }

    /**
     * 取交集
     */
    public Set<Object> intersectByKeys(List<String> keys) {
        return this.redisTemplate.opsForSet().intersect(keys);
    }

    /**
     * key1和key2取交集存储到key3
     */
    public Long intersectAndStore(String key1, String key2, String key3) {
        return this.redisTemplate.opsForSet().intersectAndStore(key1, key2, key3);
    }

    /**
     * key1和key2差集
     */
    public Set<Object> difference(String key1, String key2) {
        return this.redisTemplate.opsForSet().difference(key1, key2);
    }

    /**
     * key1和key2的交集存储到key3
     */
    public Long differenceAndStore(String key1, String key2, String key3) {
        return this.redisTemplate.opsForSet().differenceAndStore(key1, key2, key3);
    }

    /**
     * key的set是否包含member
     */
    public Boolean isMember(String key, Integer member) {
        return this.redisTemplate.opsForSet().isMember(key, member);
    }

    /**
     * 返回key的set所有member
     */
    public Set<Object> members(String key) {
        return this.redisTemplate.opsForSet().members(key);
    }

    /**
     * 返回key的set所有member
     */
    public void scan(String key) {
        Cursor<Object> cursor = this.redisTemplate.opsForSet().scan(key, ScanOptions.scanOptions().match("a").build());
        while (cursor.hasNext()) {
            Object object = cursor.next();
            System.out.println(object);
        }
    }

}

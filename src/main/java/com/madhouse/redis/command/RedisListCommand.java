package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-17 14:10
 */
@Component
public class RedisListCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 往名为key的list中尾部添加一个value元素
     */
    public void rightPush(String key, Integer value) {
        this.redisTemplate.opsForList().rightPush(key, value);
    }

    /**
     * 查找list中的value1元素,如果找到在其右边插入value2,没找到,不做任何操作
     */
    public void rightPush(String key, Integer value1, Integer value2) {
        this.redisTemplate.opsForList().rightPush(key, value1, value2);
    }

    /**
     * 往名为key的list的尾部添加一系列数据
     */
    public void rightPushAll(String key, Integer[] values) {
        this.redisTemplate.opsForList().rightPushAll(key, values);
    }

    /**
     * 往名为key的list中头部添加一个value元素
     */
    public void leftPush(String key, Integer value) {
        this.redisTemplate.opsForList().leftPush(key, value);
    }

    /**
     * 名为key的list的长度
     */
    public Long listSize(String key) {
        return this.redisTemplate.opsForList().size(key);
    }

    /**
     * 返回list中元素下标start到end之间的元素(下标从0开始)[start,end]
     */
    public List<Object> range(String key, long start, long end) {
        return this.redisTemplate.opsForList().range(key, start, end);
    }

    /**
     * 该操作是截图list,截图之后list中的元素只有下标从start到end的元素
     */
    public void trim(String key, long start, long end) {
        this.redisTemplate.opsForList().trim(key, start, end);
    }

    /**
     * 返回key对应的list中下标为index的元素
     */
    public Object index(String key, long index) {
        return this.redisTemplate.opsForList().index(key, index);
    }

    /**
     * 为list中下标为index的元素赋值为value(注意:下标为index的元素必须存在,如果不存在报错)
     */
    public void indexSetValue(String key, long index, Integer value) {
        this.redisTemplate.opsForList().set(key, index, value);
    }

    /**
     * 删除list中count个值为value的元素(当count为0时,表示删除list中所有值为value的元素)
     */
    public void remove(String key, long count, Integer value) {
        this.redisTemplate.opsForList().remove(key, count, value);
    }

    /**
     * 弹出(删除)list中首元素,并返回
     */
    public Object leftPop(String key) {
        return this.redisTemplate.opsForList().leftPop(key);
    }

    /**
     * 从名为key1的list中删除尾部元素,并将这个元素添加到名为key2的list的头部
     */
    public Object rightPopAndLeftPush(String key1, String key2) {
        return this.redisTemplate.opsForList().rightPopAndLeftPush(key1, key2);
    }
}

package com.madhouse.redis.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-16 10:27
 */
@Component
public class RedisCommand {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    /**
     * 是否存在key
     */
    public Boolean hasKey(String key) {
        return this.redisTemplate.hasKey(key);
    }

    /**
     * 删除一个key
     */
    public Boolean deleteKey(String key) {
        return this.redisTemplate.delete(key);
    }

    /**
     * 根据pattern查找keys
     */
    public Set<String> keys(String pattern) {
        return this.redisTemplate.keys(pattern);
    }

    /**
     * 随机返回key空间的一个key
     */
    public String randomKey() {
        return this.redisTemplate.randomKey();
    }

    /**
     * oldKey更新为newKey,若newKey已经存在,则删除newKey
     */
    public void reName(String oldKey, String newKey) {
        this.redisTemplate.rename(oldKey, newKey);
    }

    /**
     * 返回当前数据库的key的数目
     */
    public long dbSize() {
        return (long) this.redisTemplate.execute((RedisCallback) redisConnection -> redisConnection.dbSize());
    }

    /**
     * 设定一个可以的活动时间
     */
    public void expire(String key, long ttl) {
        this.redisTemplate.expire(key, ttl, TimeUnit.SECONDS);
    }

    /**
     * 查看key的ttl
     */
    public Long getExpire(String key) {
        return this.redisTemplate.getExpire(key);
    }

    //String操作

    public void set(String key, String value) {
        this.redisTemplate.opsForValue().set(key, value);
    }

    public String get(String key) {
        return (String) this.redisTemplate.opsForValue().get(key);
    }

    /**
     * 取出key对象的值,重置成value
     */
    public void getSet(String key, String value) {
        this.redisTemplate.opsForValue().getAndSet(key, value);
    }

    public List<Object> mget(List<String> keys) {
        return this.redisTemplate.opsForValue().multiGet(keys);
    }


    /**
     * 如果key不存在才去set
     */
    public Boolean setIfAbsent(String key, String value) {
        return this.redisTemplate.opsForValue().setIfAbsent(key, value);
    }

    /**
     * 如果key存在才去set
     */
    public Boolean setIfPresent(String key, String value) {
        return this.redisTemplate.opsForValue().setIfPresent(key, value);
    }

    /**
     * 同时设置多个key,value
     */
    public void mset(Map<String, String> map) {
        this.redisTemplate.opsForValue().multiSet(map);
    }

    /**
     * 每次key对应的value增加1
     */
    public void increment(String key) {
        this.redisTemplate.opsForValue().increment(key);
    }

    /**
     * 每次key对应的value增加value
     */
    public void incrementBy(String key, long value) {
        this.redisTemplate.opsForValue().increment(key, value);
    }

    /**
     * 每次key对应的value减小1
     */
    public void decrement(String key) {
        this.redisTemplate.opsForValue().decrement(key);
    }

    /**
     * 每次key对应的value减小value
     */
    public void decrementBy(String key, long value) {
        this.redisTemplate.opsForValue().decrement(key, value);
    }

    /**
     * key对应的值,字符串拼接value
     */
    public void append(String key, String value) {
        this.redisTemplate.opsForValue().append(key, value);
    }


    //list操作

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

    //set 操作

    /**
     * set中添加一系列member
     */
    public void setAdd(String key, Integer[] values) {
        this.redisTemplate.opsForSet().add(key, values);
    }

    /**
     * set中删除元素member
     */
    public void setRemoveMember(String key, Integer value) {
        this.redisTemplate.opsForSet().remove(key, value);
    }

    /**
     * 随机删除并返回set中的一个member
     */
    public Object setPop(String key) {
        return this.redisTemplate.opsForSet().pop(key);
    }

    /**
     * 将key1中set中的元素member移到名为key2的set中
     */
    public void setMove(String key1, Integer member, String key2) {
        this.redisTemplate.opsForSet().move(key1, member, key2);
    }


}

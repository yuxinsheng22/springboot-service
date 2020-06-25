package com.madhouse.es.join;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.madhouse.es.join.model.EsInfo;
import com.madhouse.es.join.model.EsJoinTweet;
import com.madhouse.es.join.model.EsWord;
import org.apache.commons.codec.digest.DigestUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-16 10:49
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EsTweetWordTest {

    @Autowired
    private EsTweetWordService tweetWordService;

    @Test
    public void addEsTweet() {
        String id = "1001";
        EsJoinTweet tweet = new EsJoinTweet(1001L, Lists.newArrayList(1L, 2L, 3L, 4L), new EsInfo("tweet"));
        this.tweetWordService.addTweet(id, tweet);
    }


    @Test
    public void addWord() {
        EsWord word = new EsWord("b", 0.3F, new EsInfo("word", "1000"));
        String id = DigestUtils.md5Hex(1000 + word.getWordText());
        String routing = id;
        this.tweetWordService.addWord(id, routing, word);
    }

    @Test
    public void getTweetById() {
        String id = "1000";
        EsJoinTweet tweet = this.tweetWordService.getTweetById(id);
        if (Objects.nonNull(tweet)) {
            System.out.println(JSON.toJSONString(tweet));
        }
    }

    @Test
    public void getWordById() {
        String id = "f7c731c62fe4b342252f27b6a833b1a4";
        EsWord word = this.tweetWordService.getWordById(id);
        if (Objects.nonNull(word)) {
            System.out.println(JSON.toJSONString(word));
        }
    }

    @Test
    public void updateTweet() {
        String id = "1001";
        this.tweetWordService.updateTweet(id);
    }

    @Test
    public void updateWord() {
        String id = "ff8d46f48014ff24574d813f4eccfb1b";
        this.tweetWordService.updateWord(id);
    }
}

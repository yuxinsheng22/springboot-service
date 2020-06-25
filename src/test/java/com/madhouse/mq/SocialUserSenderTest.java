package com.madhouse.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.nio.charset.StandardCharsets;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-05-21 16:53
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SocialUserSenderTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendTweetMsg() {
        this.rabbitTemplate.setExchange("tw.user_info.sa.exchange");
        this.rabbitTemplate.setRoutingKey("tw.user_info.sa.routing.key");
        Message message = MessageBuilder.withBody(msg1.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }

    private static final String msg = "{\n" +
            "  \"socialStrategyId\": 1,\n" +
            "  \"requestDay\": 20200520,\n" +
            "  \"user\": {\n" +
            "    \"id\": 843339103,\n" +
            "    \"id_str\": \"843339103\",\n" +
            "    \"name\": \"evoup\",\n" +
            "    \"screen_name\": \"evoupYin\",\n" +
            "    \"location\": \"\",\n" +
            "    \"profile_location\": null,\n" +
            "    \"description\": \"\",\n" +
            "    \"url\": null,\n" +
            "    \"entities\": {\n" +
            "      \"description\": {\n" +
            "        \"urls\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"protected\": false,\n" +
            "    \"followers_count\": 17,\n" +
            "    \"friends_count\": 209,\n" +
            "    \"listed_count\": 0,\n" +
            "    \"created_at\": \"Mon Sep 24 10:27:21 +0000 2012\",\n" +
            "    \"favourites_count\": 31,\n" +
            "    \"utc_offset\": null,\n" +
            "    \"time_zone\": null,\n" +
            "    \"geo_enabled\": false,\n" +
            "    \"verified\": false,\n" +
            "    \"statuses_count\": 74,\n" +
            "    \"lang\": null,\n" +
            "    \"status\": {\n" +
            "      \"created_at\": \"Mon May 18 07:53:44 +0000 2020\",\n" +
            "      \"id\": 1262290259317977088,\n" +
            "      \"id_str\": \"1262290259317977088\",\n" +
            "      \"text\": \"Java\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": []\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 0,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"lang\": \"es\"\n" +
            "    },\n" +
            "    \"contributors_enabled\": false,\n" +
            "    \"is_translator\": false,\n" +
            "    \"is_translation_enabled\": false,\n" +
            "    \"profile_background_color\": \"C0DEED\",\n" +
            "    \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "    \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "    \"profile_background_tile\": false,\n" +
            "    \"profile_image_url\": \"http://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "    \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "    \"profile_link_color\": \"1DA1F2\",\n" +
            "    \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "    \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "    \"profile_text_color\": \"333333\",\n" +
            "    \"profile_use_background_image\": true,\n" +
            "    \"has_extended_profile\": false,\n" +
            "    \"default_profile\": true,\n" +
            "    \"default_profile_image\": false,\n" +
            "    \"following\": null,\n" +
            "    \"follow_request_sent\": null,\n" +
            "    \"notifications\": null,\n" +
            "    \"translator_type\": \"none\"\n" +
            "  }\n" +
            "}";

    private static final String msg1 = "{\n" +
            "  \"socialStrategyId\": 5,\n" +
            "  \"requestDay\": 20200527,\n" +
            "  \"user\": {\n" +
            "    \"id\": 170616732,\n" +
            "    \"id_str\": \"170616732\",\n" +
            "    \"name\": \"Varun Vijay\",\n" +
            "    \"screen_name\": \"varun18vijay\",\n" +
            "    \"location\": \"Bengaluru, India\",\n" +
            "    \"profile_location\": {\n" +
            "      \"id\": \"1b8680cd52a711cb\",\n" +
            "      \"url\": \"https://api.twitter.com/1.1/geo/id/1b8680cd52a711cb.json\",\n" +
            "      \"place_type\": \"unknown\",\n" +
            "      \"name\": \"Bengaluru, India\",\n" +
            "      \"full_name\": \"Bengaluru, India\",\n" +
            "      \"country_code\": \"\",\n" +
            "      \"country\": \"\",\n" +
            "      \"contained_within\": [],\n" +
            "      \"bounding_box\": null,\n" +
            "      \"attributes\": {}\n" +
            "    },\n" +
            "    \"description\": \"News-Curator Content-Curator Political-Analyst Patriot \\n(Subliminal/Hidden Messages Decoder) Trend-Spotter\\nRetweets, Likes imply #interesting, NOT endorsements\",\n" +
            "    \"url\": null,\n" +
            "    \"entities\": {\n" +
            "      \"description\": {\n" +
            "        \"urls\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"protected\": false,\n" +
            "    \"followers_count\": 1370,\n" +
            "    \"friends_count\": 4121,\n" +
            "    \"listed_count\": 541,\n" +
            "    \"created_at\": \"Sun Jul 25 08:52:17 +0000 2010\",\n" +
            "    \"favourites_count\": 147364,\n" +
            "    \"utc_offset\": null,\n" +
            "    \"time_zone\": null,\n" +
            "    \"geo_enabled\": true,\n" +
            "    \"verified\": false,\n" +
            "    \"statuses_count\": 590243,\n" +
            "    \"lang\": null,\n" +
            "    \"status\": {\n" +
            "      \"created_at\": \"Wed May 27 02:03:27 +0000 2020\",\n" +
            "      \"id\": 1265463596034568192,\n" +
            "      \"id_str\": \"1265463596034568192\",\n" +
            "      \"text\": \"RT @htTweets: Chinese lawmakers propose foreign states immunities law to counter Covid-19 lawsuit in the US\\n\\nhttps://t.co/B3k7G82VDh https:…\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"htTweets\",\n" +
            "            \"name\": \"Hindustan Times\",\n" +
            "            \"id\": 36327407,\n" +
            "            \"id_str\": \"36327407\",\n" +
            "            \"indices\": [\n" +
            "              3,\n" +
            "              12\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/B3k7G82VDh\",\n" +
            "            \"expanded_url\": \"https://www.hindustantimes.com/world-news/chinese-lawmakers-propose-foreign-states-immunities-law-to-counter-covid-19-lawsuit-in-the-us/story-HaiJQT59lj4h86wlUiHHKM.html\",\n" +
            "            \"display_url\": \"hindustantimes.com/world-news/chi…\",\n" +
            "            \"indices\": [\n" +
            "              109,\n" +
            "              132\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://www.tweetcaster.com\\\" rel=\\\"nofollow\\\">TweetCaster for Android</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"retweeted_status\": {\n" +
            "        \"created_at\": \"Tue May 26 17:43:34 +0000 2020\",\n" +
            "        \"id\": 1265337799747592192,\n" +
            "        \"id_str\": \"1265337799747592192\",\n" +
            "        \"text\": \"Chinese lawmakers propose foreign states immunities law to counter Covid-19 lawsuit in the US… https://t.co/ndC4clWN2B\",\n" +
            "        \"truncated\": true,\n" +
            "        \"entities\": {\n" +
            "          \"hashtags\": [],\n" +
            "          \"symbols\": [],\n" +
            "          \"user_mentions\": [],\n" +
            "          \"urls\": [\n" +
            "            {\n" +
            "              \"url\": \"https://t.co/ndC4clWN2B\",\n" +
            "              \"expanded_url\": \"https://twitter.com/i/web/status/1265337799747592192\",\n" +
            "              \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "              \"indices\": [\n" +
            "                95,\n" +
            "                118\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        \"source\": \"<a href=\\\"https://about.twitter.com/products/tweetdeck\\\" rel=\\\"nofollow\\\">TweetDeck</a>\",\n" +
            "        \"in_reply_to_status_id\": null,\n" +
            "        \"in_reply_to_status_id_str\": null,\n" +
            "        \"in_reply_to_user_id\": null,\n" +
            "        \"in_reply_to_user_id_str\": null,\n" +
            "        \"in_reply_to_screen_name\": null,\n" +
            "        \"geo\": null,\n" +
            "        \"coordinates\": null,\n" +
            "        \"place\": null,\n" +
            "        \"contributors\": null,\n" +
            "        \"is_quote_status\": false,\n" +
            "        \"retweet_count\": 13,\n" +
            "        \"favorite_count\": 46,\n" +
            "        \"favorited\": false,\n" +
            "        \"retweeted\": false,\n" +
            "        \"possibly_sensitive\": false,\n" +
            "        \"lang\": \"en\"\n" +
            "      },\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 13,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    \"contributors_enabled\": false,\n" +
            "    \"is_translator\": false,\n" +
            "    \"is_translation_enabled\": false,\n" +
            "    \"profile_background_color\": \"000000\",\n" +
            "    \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme10/bg.gif\",\n" +
            "    \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme10/bg.gif\",\n" +
            "    \"profile_background_tile\": false,\n" +
            "    \"profile_image_url\": \"http://pbs.twimg.com/profile_images/935222877552439296/BgV5exfZ_normal.jpg\",\n" +
            "    \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/935222877552439296/BgV5exfZ_normal.jpg\",\n" +
            "    \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/170616732/1511807483\",\n" +
            "    \"profile_link_color\": \"1B95E0\",\n" +
            "    \"profile_sidebar_border_color\": \"000000\",\n" +
            "    \"profile_sidebar_fill_color\": \"000000\",\n" +
            "    \"profile_text_color\": \"000000\",\n" +
            "    \"profile_use_background_image\": false,\n" +
            "    \"has_extended_profile\": true,\n" +
            "    \"default_profile\": false,\n" +
            "    \"default_profile_image\": false,\n" +
            "    \"following\": null,\n" +
            "    \"follow_request_sent\": null,\n" +
            "    \"notifications\": null,\n" +
            "    \"translator_type\": \"none\"\n" +
            "  }\n" +
            "}";
}

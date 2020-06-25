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
 * @date: 2020-05-18 11:19
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class SocialAccountPostSenderTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendTweetMsg() {
        this.rabbitTemplate.setExchange("tw.social_account_tweet.exchange");
        this.rabbitTemplate.setRoutingKey("tw.social_account_tweet.routing.key");
        Message message = MessageBuilder.withBody(原创.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }

    private static final String 原创 = "{\n" +
            "  \"socialAccountStrategyId\": 1,\n" +
            "  \"mediaType\": 0,\n" +
            "  \"postObject\": {\n" +
            "    \"created_at\": \"Tue May 12 09:21:24 +0000 2020\",\n" +
            "    \"id\": 1260137993077047297,\n" +
            "    \"id_str\": \"1260137993077047297\",\n" +
            "    \"text\": \"傻瓜青蛙☺️☺️ https://t.co/1ltsB6TWNp\",\n" +
            "    \"truncated\": false,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [],\n" +
            "      \"symbols\": [],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"urls\": [],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"id\": 1260137808204718080,\n" +
            "          \"id_str\": \"1260137808204718080\",\n" +
            "          \"indices\": [\n" +
            "            9,\n" +
            "            32\n" +
            "          ],\n" +
            "          \"media_url\": \"http://pbs.twimg.com/media/EXzoqPoU4AAxlyF.jpg\",\n" +
            "          \"media_url_https\": \"https://pbs.twimg.com/media/EXzoqPoU4AAxlyF.jpg\",\n" +
            "          \"url\": \"https://t.co/1ltsB6TWNp\",\n" +
            "          \"display_url\": \"pic.twitter.com/1ltsB6TWNp\",\n" +
            "          \"expanded_url\": \"https://twitter.com/evoupYin/status/1260137993077047297/photo/1\",\n" +
            "          \"type\": \"photo\",\n" +
            "          \"sizes\": {\n" +
            "            \"thumb\": {\n" +
            "              \"w\": 150,\n" +
            "              \"h\": 150,\n" +
            "              \"resize\": \"crop\"\n" +
            "            },\n" +
            "            \"medium\": {\n" +
            "              \"w\": 1200,\n" +
            "              \"h\": 1200,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"large\": {\n" +
            "              \"w\": 1657,\n" +
            "              \"h\": 1657,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"small\": {\n" +
            "              \"w\": 680,\n" +
            "              \"h\": 680,\n" +
            "              \"resize\": \"fit\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"extended_entities\": {\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"id\": 1260137808204718080,\n" +
            "          \"id_str\": \"1260137808204718080\",\n" +
            "          \"indices\": [\n" +
            "            9,\n" +
            "            32\n" +
            "          ],\n" +
            "          \"media_url\": \"http://pbs.twimg.com/media/EXzoqPoU4AAxlyF.jpg\",\n" +
            "          \"media_url_https\": \"https://pbs.twimg.com/media/EXzoqPoU4AAxlyF.jpg\",\n" +
            "          \"url\": \"https://t.co/1ltsB6TWNp\",\n" +
            "          \"display_url\": \"pic.twitter.com/1ltsB6TWNp\",\n" +
            "          \"expanded_url\": \"https://twitter.com/evoupYin/status/1260137993077047297/photo/1\",\n" +
            "          \"type\": \"photo\",\n" +
            "          \"sizes\": {\n" +
            "            \"thumb\": {\n" +
            "              \"w\": 150,\n" +
            "              \"h\": 150,\n" +
            "              \"resize\": \"crop\"\n" +
            "            },\n" +
            "            \"medium\": {\n" +
            "              \"w\": 1200,\n" +
            "              \"h\": 1200,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"large\": {\n" +
            "              \"w\": 1657,\n" +
            "              \"h\": 1657,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"small\": {\n" +
            "              \"w\": 680,\n" +
            "              \"h\": 680,\n" +
            "              \"resize\": \"fit\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 843339103,\n" +
            "      \"id_str\": \"843339103\",\n" +
            "      \"name\": \"evoup\",\n" +
            "      \"screen_name\": \"evoupYin\",\n" +
            "      \"location\": \"\",\n" +
            "      \"description\": \"\",\n" +
            "      \"url\": null,\n" +
            "      \"entities\": {\n" +
            "        \"description\": {\n" +
            "          \"urls\": []\n" +
            "        }\n" +
            "      },\n" +
            "      \"protected\": false,\n" +
            "      \"followers_count\": 17,\n" +
            "      \"friends_count\": 209,\n" +
            "      \"listed_count\": 0,\n" +
            "      \"created_at\": \"Mon Sep 24 10:27:21 +0000 2012\",\n" +
            "      \"favourites_count\": 31,\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"statuses_count\": 73,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"is_translation_enabled\": false,\n" +
            "      \"profile_background_color\": \"C0DEED\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "      \"profile_link_color\": \"1DA1F2\",\n" +
            "      \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "      \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "      \"profile_text_color\": \"333333\",\n" +
            "      \"profile_use_background_image\": true,\n" +
            "      \"has_extended_profile\": false,\n" +
            "      \"default_profile\": true,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null,\n" +
            "      \"translator_type\": \"none\"\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"retweet_count\": 0,\n" +
            "    \"favorite_count\": 0,\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"lang\": \"ja\"\n" +
            "  }\n" +
            "}";

    private static final String 转推="{\n" +
            "  \"socialAccountStrategyId\": 1,\n" +
            "  \"mediaType\": 0,\n" +
            "  \"postObject\": {\n" +
            "    \"created_at\": \"Tue May 12 07:18:35 +0000 2020\",\n" +
            "    \"id\": 1260107084370043000,\n" +
            "    \"id_str\": \"1260107084370042880\",\n" +
            "    \"text\": \"RT @PDChinaLife: This is a way to delight your kitten. #CatsOfTwitter https://t.co/TEW0ElzCU4\",\n" +
            "    \"truncated\": false,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [\n" +
            "        {\n" +
            "          \"text\": \"CatsOfTwitter\",\n" +
            "          \"indices\": [\n" +
            "            55,\n" +
            "            69\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"symbols\": [],\n" +
            "      \"user_mentions\": [\n" +
            "        {\n" +
            "          \"screen_name\": \"PDChinaLife\",\n" +
            "          \"name\": \"Beautiful China\",\n" +
            "          \"id\": 1164937093656862700,\n" +
            "          \"id_str\": \"1164937093656862720\",\n" +
            "          \"indices\": [\n" +
            "            3,\n" +
            "            15\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"urls\": [],\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"id\": 1260039619648737300,\n" +
            "          \"id_str\": \"1260039619648737281\",\n" +
            "          \"indices\": [\n" +
            "            70,\n" +
            "            93\n" +
            "          ],\n" +
            "          \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "          \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "          \"url\": \"https://t.co/TEW0ElzCU4\",\n" +
            "          \"display_url\": \"pic.twitter.com/TEW0ElzCU4\",\n" +
            "          \"expanded_url\": \"https://twitter.com/PDChinaLife/status/1260039648979476480/video/1\",\n" +
            "          \"type\": \"photo\",\n" +
            "          \"sizes\": {\n" +
            "            \"thumb\": {\n" +
            "              \"w\": 150,\n" +
            "              \"h\": 150,\n" +
            "              \"resize\": \"crop\"\n" +
            "            },\n" +
            "            \"small\": {\n" +
            "              \"w\": 383,\n" +
            "              \"h\": 680,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"large\": {\n" +
            "              \"w\": 720,\n" +
            "              \"h\": 1280,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"medium\": {\n" +
            "              \"w\": 675,\n" +
            "              \"h\": 1200,\n" +
            "              \"resize\": \"fit\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"source_status_id\": 1260039648979476500,\n" +
            "          \"source_status_id_str\": \"1260039648979476480\",\n" +
            "          \"source_user_id\": 1164937093656862700,\n" +
            "          \"source_user_id_str\": \"1164937093656862720\"\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"extended_entities\": {\n" +
            "      \"media\": [\n" +
            "        {\n" +
            "          \"id\": 1260039619648737300,\n" +
            "          \"id_str\": \"1260039619648737281\",\n" +
            "          \"indices\": [\n" +
            "            70,\n" +
            "            93\n" +
            "          ],\n" +
            "          \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "          \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "          \"url\": \"https://t.co/TEW0ElzCU4\",\n" +
            "          \"display_url\": \"pic.twitter.com/TEW0ElzCU4\",\n" +
            "          \"expanded_url\": \"https://twitter.com/PDChinaLife/status/1260039648979476480/video/1\",\n" +
            "          \"type\": \"video\",\n" +
            "          \"sizes\": {\n" +
            "            \"thumb\": {\n" +
            "              \"w\": 150,\n" +
            "              \"h\": 150,\n" +
            "              \"resize\": \"crop\"\n" +
            "            },\n" +
            "            \"small\": {\n" +
            "              \"w\": 383,\n" +
            "              \"h\": 680,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"large\": {\n" +
            "              \"w\": 720,\n" +
            "              \"h\": 1280,\n" +
            "              \"resize\": \"fit\"\n" +
            "            },\n" +
            "            \"medium\": {\n" +
            "              \"w\": 675,\n" +
            "              \"h\": 1200,\n" +
            "              \"resize\": \"fit\"\n" +
            "            }\n" +
            "          },\n" +
            "          \"source_status_id\": 1260039648979476500,\n" +
            "          \"source_status_id_str\": \"1260039648979476480\",\n" +
            "          \"source_user_id\": 1164937093656862700,\n" +
            "          \"source_user_id_str\": \"1164937093656862720\",\n" +
            "          \"video_info\": {\n" +
            "            \"aspect_ratio\": [\n" +
            "              9,\n" +
            "              16\n" +
            "            ],\n" +
            "            \"duration_millis\": 10720,\n" +
            "            \"variants\": [\n" +
            "              {\n" +
            "                \"bitrate\": 2176000,\n" +
            "                \"content_type\": \"video/mp4\",\n" +
            "                \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/720x1280/GUpqVVUW9iDcTMMP.mp4?tag=10\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"content_type\": \"application/x-mpegURL\",\n" +
            "                \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/pl/aLpDkuECuFqan4FM.m3u8?tag=10\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"bitrate\": 832000,\n" +
            "                \"content_type\": \"video/mp4\",\n" +
            "                \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/360x640/7mDNHr3R7pipV4_e.mp4?tag=10\"\n" +
            "              },\n" +
            "              {\n" +
            "                \"bitrate\": 632000,\n" +
            "                \"content_type\": \"video/mp4\",\n" +
            "                \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/320x568/YnTGnkJkFYWnoDz2.mp4?tag=10\"\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"additional_media_info\": {\n" +
            "            \"monetizable\": false,\n" +
            "            \"source_user\": {\n" +
            "              \"id\": 1164937093656862700,\n" +
            "              \"id_str\": \"1164937093656862720\",\n" +
            "              \"name\": \"Beautiful China\",\n" +
            "              \"screen_name\": \"PDChinaLife\",\n" +
            "              \"location\": \"Beijing, China\",\n" +
            "              \"description\": \"Timely updates info on Chinese culture, life and travel. Run by @PDChina, the largest newspaper group in China\",\n" +
            "              \"url\": \"https://t.co/iDLiVdL2RX\",\n" +
            "              \"entities\": {\n" +
            "                \"url\": {\n" +
            "                  \"urls\": [\n" +
            "                    {\n" +
            "                      \"url\": \"https://t.co/iDLiVdL2RX\",\n" +
            "                      \"expanded_url\": \"http://people.cn\",\n" +
            "                      \"display_url\": \"people.cn\",\n" +
            "                      \"indices\": [\n" +
            "                        0,\n" +
            "                        23\n" +
            "                      ]\n" +
            "                    }\n" +
            "                  ]\n" +
            "                },\n" +
            "                \"description\": {\n" +
            "                  \"urls\": []\n" +
            "                }\n" +
            "              },\n" +
            "              \"protected\": false,\n" +
            "              \"followers_count\": 828453,\n" +
            "              \"friends_count\": 24,\n" +
            "              \"listed_count\": 152,\n" +
            "              \"created_at\": \"Fri Aug 23 16:27:22 +0000 2019\",\n" +
            "              \"favourites_count\": 0,\n" +
            "              \"utc_offset\": null,\n" +
            "              \"time_zone\": null,\n" +
            "              \"geo_enabled\": false,\n" +
            "              \"verified\": true,\n" +
            "              \"statuses_count\": 1251,\n" +
            "              \"lang\": null,\n" +
            "              \"contributors_enabled\": false,\n" +
            "              \"is_translator\": false,\n" +
            "              \"is_translation_enabled\": false,\n" +
            "              \"profile_background_color\": \"F5F8FA\",\n" +
            "              \"profile_background_image_url\": null,\n" +
            "              \"profile_background_image_url_https\": null,\n" +
            "              \"profile_background_tile\": false,\n" +
            "              \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1184853004660424711/bbORYS1b_normal.jpg\",\n" +
            "              \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1184853004660424711/bbORYS1b_normal.jpg\",\n" +
            "              \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/1164937093656862720/1572981837\",\n" +
            "              \"profile_link_color\": \"1DA1F2\",\n" +
            "              \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "              \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "              \"profile_text_color\": \"333333\",\n" +
            "              \"profile_use_background_image\": true,\n" +
            "              \"has_extended_profile\": false,\n" +
            "              \"default_profile\": true,\n" +
            "              \"default_profile_image\": false,\n" +
            "              \"following\": null,\n" +
            "              \"follow_request_sent\": null,\n" +
            "              \"notifications\": null,\n" +
            "              \"translator_type\": \"none\"\n" +
            "            }\n" +
            "          }\n" +
            "        }\n" +
            "      ]\n" +
            "    },\n" +
            "    \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 843339103,\n" +
            "      \"id_str\": \"843339103\",\n" +
            "      \"name\": \"evoup\",\n" +
            "      \"screen_name\": \"evoupYin\",\n" +
            "      \"location\": \"\",\n" +
            "      \"description\": \"\",\n" +
            "      \"url\": null,\n" +
            "      \"entities\": {\n" +
            "        \"description\": {\n" +
            "          \"urls\": []\n" +
            "        }\n" +
            "      },\n" +
            "      \"protected\": false,\n" +
            "      \"followers_count\": 16,\n" +
            "      \"friends_count\": 208,\n" +
            "      \"listed_count\": 0,\n" +
            "      \"created_at\": \"Mon Sep 24 10:27:21 +0000 2012\",\n" +
            "      \"favourites_count\": 31,\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"statuses_count\": 70,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"is_translation_enabled\": false,\n" +
            "      \"profile_background_color\": \"C0DEED\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/417190194236772352/5iyjqvhM_normal.png\",\n" +
            "      \"profile_link_color\": \"1DA1F2\",\n" +
            "      \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "      \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "      \"profile_text_color\": \"333333\",\n" +
            "      \"profile_use_background_image\": true,\n" +
            "      \"has_extended_profile\": false,\n" +
            "      \"default_profile\": true,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null,\n" +
            "      \"translator_type\": \"none\"\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"retweeted_status\": {\n" +
            "      \"created_at\": \"Tue May 12 02:50:37 +0000 2020\",\n" +
            "      \"id\": 1260039648979476500,\n" +
            "      \"id_str\": \"1260039648979476480\",\n" +
            "      \"text\": \"This is a way to delight your kitten. #CatsOfTwitter https://t.co/TEW0ElzCU4\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"CatsOfTwitter\",\n" +
            "            \"indices\": [\n" +
            "              38,\n" +
            "              52\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"urls\": [],\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1260039619648737300,\n" +
            "            \"id_str\": \"1260039619648737281\",\n" +
            "            \"indices\": [\n" +
            "              53,\n" +
            "              76\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "            \"url\": \"https://t.co/TEW0ElzCU4\",\n" +
            "            \"display_url\": \"pic.twitter.com/TEW0ElzCU4\",\n" +
            "            \"expanded_url\": \"https://twitter.com/PDChinaLife/status/1260039648979476480/video/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 383,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 720,\n" +
            "                \"h\": 1280,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 675,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"extended_entities\": {\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1260039619648737300,\n" +
            "            \"id_str\": \"1260039619648737281\",\n" +
            "            \"indices\": [\n" +
            "              53,\n" +
            "              76\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1260039619648737281/pu/img/xdYXvNAbRNKstwfb.jpg\",\n" +
            "            \"url\": \"https://t.co/TEW0ElzCU4\",\n" +
            "            \"display_url\": \"pic.twitter.com/TEW0ElzCU4\",\n" +
            "            \"expanded_url\": \"https://twitter.com/PDChinaLife/status/1260039648979476480/video/1\",\n" +
            "            \"type\": \"video\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 383,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 720,\n" +
            "                \"h\": 1280,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 675,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            },\n" +
            "            \"video_info\": {\n" +
            "              \"aspect_ratio\": [\n" +
            "                9,\n" +
            "                16\n" +
            "              ],\n" +
            "              \"duration_millis\": 10720,\n" +
            "              \"variants\": [\n" +
            "                {\n" +
            "                  \"bitrate\": 2176000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/720x1280/GUpqVVUW9iDcTMMP.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"content_type\": \"application/x-mpegURL\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/pl/aLpDkuECuFqan4FM.m3u8?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 832000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/360x640/7mDNHr3R7pipV4_e.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 632000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1260039619648737281/pu/vid/320x568/YnTGnkJkFYWnoDz2.mp4?tag=10\"\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            \"additional_media_info\": {\n" +
            "              \"monetizable\": false\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"https://about.twitter.com/products/tweetdeck\\\" rel=\\\"nofollow\\\">TweetDeck</a>\",\n" +
            "      \"in_reply_to_status_id\": null,\n" +
            "      \"in_reply_to_status_id_str\": null,\n" +
            "      \"in_reply_to_user_id\": null,\n" +
            "      \"in_reply_to_user_id_str\": null,\n" +
            "      \"in_reply_to_screen_name\": null,\n" +
            "      \"user\": {\n" +
            "        \"id\": 1164937093656862700,\n" +
            "        \"id_str\": \"1164937093656862720\",\n" +
            "        \"name\": \"Beautiful China\",\n" +
            "        \"screen_name\": \"PDChinaLife\",\n" +
            "        \"location\": \"Beijing, China\",\n" +
            "        \"description\": \"Timely updates info on Chinese culture, life and travel. Run by @PDChina, the largest newspaper group in China\",\n" +
            "        \"url\": \"https://t.co/iDLiVdL2RX\",\n" +
            "        \"entities\": {\n" +
            "          \"url\": {\n" +
            "            \"urls\": [\n" +
            "              {\n" +
            "                \"url\": \"https://t.co/iDLiVdL2RX\",\n" +
            "                \"expanded_url\": \"http://people.cn\",\n" +
            "                \"display_url\": \"people.cn\",\n" +
            "                \"indices\": [\n" +
            "                  0,\n" +
            "                  23\n" +
            "                ]\n" +
            "              }\n" +
            "            ]\n" +
            "          },\n" +
            "          \"description\": {\n" +
            "            \"urls\": []\n" +
            "          }\n" +
            "        },\n" +
            "        \"protected\": false,\n" +
            "        \"followers_count\": 828453,\n" +
            "        \"friends_count\": 24,\n" +
            "        \"listed_count\": 152,\n" +
            "        \"created_at\": \"Fri Aug 23 16:27:22 +0000 2019\",\n" +
            "        \"favourites_count\": 0,\n" +
            "        \"utc_offset\": null,\n" +
            "        \"time_zone\": null,\n" +
            "        \"geo_enabled\": false,\n" +
            "        \"verified\": true,\n" +
            "        \"statuses_count\": 1251,\n" +
            "        \"lang\": null,\n" +
            "        \"contributors_enabled\": false,\n" +
            "        \"is_translator\": false,\n" +
            "        \"is_translation_enabled\": false,\n" +
            "        \"profile_background_color\": \"F5F8FA\",\n" +
            "        \"profile_background_image_url\": null,\n" +
            "        \"profile_background_image_url_https\": null,\n" +
            "        \"profile_background_tile\": false,\n" +
            "        \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1184853004660424711/bbORYS1b_normal.jpg\",\n" +
            "        \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1184853004660424711/bbORYS1b_normal.jpg\",\n" +
            "        \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/1164937093656862720/1572981837\",\n" +
            "        \"profile_link_color\": \"1DA1F2\",\n" +
            "        \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "        \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "        \"profile_text_color\": \"333333\",\n" +
            "        \"profile_use_background_image\": true,\n" +
            "        \"has_extended_profile\": false,\n" +
            "        \"default_profile\": true,\n" +
            "        \"default_profile_image\": false,\n" +
            "        \"following\": null,\n" +
            "        \"follow_request_sent\": null,\n" +
            "        \"notifications\": null,\n" +
            "        \"translator_type\": \"none\"\n" +
            "      },\n" +
            "      \"geo\": null,\n" +
            "      \"coordinates\": null,\n" +
            "      \"place\": null,\n" +
            "      \"contributors\": null,\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 27,\n" +
            "      \"favorite_count\": 151,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"en\"\n" +
            "    },\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"retweet_count\": 27,\n" +
            "    \"favorite_count\": 0,\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"lang\": \"en\"\n" +
            "  }\n" +
            "}";

}

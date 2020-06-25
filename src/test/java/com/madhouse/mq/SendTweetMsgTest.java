package com.madhouse.mq;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-04-15 09:43
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SendTweetMsgTest {

    @Autowired
    private Producer producer;

    @Test
    public void sendMsg() {
        String msg = "a";
        for (int i = 0; i < 10; i++) {
            this.producer.sendMsg(msg);
        }
    }

    @Test
    public void sendTweetMsg() {
//        for (int i = 0; i < 5; i++) {
//        }
        this.producer.sendTweetMsg(MSG5);
    }

//    @Test
//    public void sendRetweetMsg() {
//        String msg = "a";
//        for (int i = 0; i < 5; i++) {
//            this.producer.sendRetweetMsg(msg);
//        }
//    }

    private static final String MSG = "{\n" +
            "  \"strategy_id\": 1,\n" +
            "  \"lang\": \"us\",\n" +
            "  \"place_country\": \"us\",\n" +
            "  \"tweet\": {\n" +
            "    \"created_at\": \"Fri Apr 24 08:00:59 +0000 2020\",\n" +
            "    \"id\": 1253594776320049152,\n" +
            "    \"id_str\": \"1253594776320049152\",\n" +
            "    \"text\": \"Donald Trump a évoqué, sans grande préparation, les effets des rayons UV et du détergent sur la maladie, sous les r… https://t.co/UvylCyKrVo\",\n" +
            "    \"source\": \"<a href=\\\"https://www.echobox.com\\\" rel=\\\"nofollow\\\">Echobox Social</a>\",\n" +
            "    \"truncated\": true,\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 8460572,\n" +
            "      \"id_str\": \"8460572\",\n" +
            "      \"name\": \"Le Point\",\n" +
            "      \"screen_name\": \"LePoint\",\n" +
            "      \"location\": \"Paris\",\n" +
            "      \"url\": \"https://www.lepoint.fr\",\n" +
            "      \"description\": \"Retrouvez nos informations exclusives et l’actualité en continu sur http://LePoint.fr. \\nAbonnez-vous pour 1 € le 1er mois ➡️ https://bit.ly/3cET45a\",\n" +
            "      \"translator_type\": \"none\",\n" +
            "      \"derived\": {\n" +
            "        \"locations\": [\n" +
            "          {\n" +
            "            \"country\": \"France\",\n" +
            "            \"country_code\": \"FR\",\n" +
            "            \"locality\": \"Paris\",\n" +
            "            \"region\": \"Île-de-France\",\n" +
            "            \"sub_region\": \"Paris\",\n" +
            "            \"full_name\": \"Paris, Île-de-France, France\",\n" +
            "            \"geo\": {\n" +
            "              \"coordinates\": [\n" +
            "                2.3488,\n" +
            "                48.85341\n" +
            "              ],\n" +
            "              \"type\": \"point\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"protected\": false,\n" +
            "      \"verified\": true,\n" +
            "      \"followers_count\": 818746,\n" +
            "      \"friends_count\": 1261,\n" +
            "      \"listed_count\": 5647,\n" +
            "      \"favourites_count\": 5989,\n" +
            "      \"statuses_count\": 213976,\n" +
            "      \"created_at\": \"Mon Aug 27 12:40:16 +0000 2007\",\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": true,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"profile_background_color\": \"3E3E3E\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_link_color\": \"AC0000\",\n" +
            "      \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "      \"profile_sidebar_fill_color\": \"C2C2C2\",\n" +
            "      \"profile_text_color\": \"000000\",\n" +
            "      \"profile_use_background_image\": false,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1219289227990573056/v2xfnDzV_normal.jpg\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1219289227990573056/v2xfnDzV_normal.jpg\",\n" +
            "      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/8460572/1584471247\",\n" +
            "      \"default_profile\": false,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"extended_tweet\": {\n" +
            "      \"full_text\": \"Donald Trump a évoqué, sans grande préparation, les effets des rayons UV et du détergent sur la maladie, sous les regards estomaqués de son équipe de conseiller. https://t.co/25RZz5ytCE #ConfinementJour39 #Covid19\",\n" +
            "      \"display_text_range\": [\n" +
            "        0,\n" +
            "        213\n" +
            "      ],\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"ConfinementJour39\",\n" +
            "            \"indices\": [\n" +
            "              186,\n" +
            "              204\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"Covid19\",\n" +
            "            \"indices\": [\n" +
            "              205,\n" +
            "              213\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/25RZz5ytCE\",\n" +
            "            \"expanded_url\": \"https://www.lepoint.fr/monde/pour-eliminer-le-coronavirus-trump-suggere-des-uv-et-du-detergent-24-04-2020-2372701_24.php?utm_medium=Social&utm_source=Twitter&Echobox=1587714577#xtor=CS1-32-%5BEchobox%5D\",\n" +
            "            \"display_url\": \"lepoint.fr/monde/pour-eli…\",\n" +
            "            \"unwound\": {\n" +
            "              \"url\": \"https://www.lepoint.fr/monde/pour-eliminer-le-coronavirus-trump-suggere-des-uv-et-du-detergent-24-04-2020-2372701_24.php?utm_medium=Social&utm_source=Twitter&Echobox=1587714577#xtor=CS1-32-%5BEchobox%5D\",\n" +
            "              \"status\": 200,\n" +
            "              \"title\": \"Pour éliminer le coronavirus, Trump suggère des UV et du détergent\",\n" +
            "              \"description\": \"Le président américain a pris la parole après la présentation d'une étude expérimentale du gouvernement américain sur le sujet, explique « 20 Minutes ».\"\n" +
            "            },\n" +
            "            \"indices\": [\n" +
            "              162,\n" +
            "              185\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"symbols\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"quote_count\": 0,\n" +
            "    \"reply_count\": 0,\n" +
            "    \"retweet_count\": 25,\n" +
            "    \"favorite_count\": 0,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [],\n" +
            "      \"urls\": [\n" +
            "        {\n" +
            "          \"url\": \"https://t.co/UvylCyKrVo\",\n" +
            "          \"expanded_url\": \"https://twitter.com/i/web/status/1253594776320049152\",\n" +
            "          \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "          \"indices\": [\n" +
            "            117,\n" +
            "            140\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"symbols\": []\n" +
            "    },\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"filter_level\": \"low\",\n" +
            "    \"lang\": \"fr\",\n" +
            "    \"matching_rules\": [\n" +
            "      {\n" +
            "        \"tag\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    private static final String MSG2 = "{\n" +
            "  \"strategy_id\": 2,\n" +
            "  \"lang\": \"us\",\n" +
            "  \"place_country\": \"us\",\n" +
            "  \"tweet\": {\n" +
            "    \"created_at\": \"Sun Apr 26 06:23:53 +0000 2020\",\n" +
            "    \"id\": 1254295112122691584,\n" +
            "    \"id_str\": \"1254295112122691584\",\n" +
            "    \"text\": \"名詞(N2程度) 【日常(にちじょう)】[0](中文:日常) 例:新型コロナウイルスは、わたしたちの日常を変えてしまった。(中文:新冠病毒改變我們的日常。) 変える(かえる)\",\n" +
            "    \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "    \"truncated\": false,\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 61200750,\n" +
            "      \"id_str\": \"61200750\",\n" +
            "      \"name\": \"犬山俊之\",\n" +
            "      \"screen_name\": \"inuyamanihongo\",\n" +
            "      \"location\": \"台中　Taichung, Taiwan\",\n" +
            "      \"url\": \"https://www.inuyamatw.com/\",\n" +
            "      \"description\": \"日本語教師＠台中(台湾)  犬山日語教室 http://inuyamatw.com\",\n" +
            "      \"translator_type\": \"none\",\n" +
            "      \"protected\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"followers_count\": 4777,\n" +
            "      \"friends_count\": 1848,\n" +
            "      \"listed_count\": 203,\n" +
            "      \"favourites_count\": 140803,\n" +
            "      \"statuses_count\": 20880,\n" +
            "      \"created_at\": \"Wed Jul 29 14:00:54 +0000 2009\",\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": false,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"profile_background_color\": \"C0DEED\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_link_color\": \"1DA1F2\",\n" +
            "      \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "      \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "      \"profile_text_color\": \"333333\",\n" +
            "      \"profile_use_background_image\": true,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1111455647512453122/E0DrVbXk_normal.png\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1111455647512453122/E0DrVbXk_normal.png\",\n" +
            "      \"default_profile\": true,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"quote_count\": 0,\n" +
            "    \"reply_count\": 0,\n" +
            "    \"retweet_count\": 1,\n" +
            "    \"favorite_count\": 2,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [],\n" +
            "      \"urls\": [],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"symbols\": []\n" +
            "    },\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"filter_level\": \"low\",\n" +
            "    \"lang\": \"ja\",\n" +
            "    \"matching_rules\": [\n" +
            "      {\n" +
            "        \"tag\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";


    private static final String MSG3 = "{\n" +
            "  \"strategy_id\": 2,\n" +
            "  \"lang\": \"us\",\n" +
            "  \"place_country\": \"us\",\n" +
            "  \"collect_emotion\": true,\n" +
            "  \"collect_entity\": true,\n" +
            "  \"tweet\": {\n" +
            "    \"created_at\": \"Wed Apr 29 09:55:10 +0000 2020\",\n" +
            "    \"id\": 1255435450686345217,\n" +
            "    \"id_str\": \"1255435450686345217\",\n" +
            "    \"text\": \"Girls don’t want boyfriends they want Huang Renjun in the second verse of Quiet Down\\n#RIDINwithNCTDREAM… https://t.co/qmlXiLhaiS\",\n" +
            "    \"source\": \"<a href=\\\"http://twitter.com/download/iphone\\\" rel=\\\"nofollow\\\">Twitter for iPhone</a>\",\n" +
            "    \"truncated\": true,\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 1220586138659934209,\n" +
            "      \"id_str\": \"1220586138659934209\",\n" +
            "      \"name\": \"alex\",\n" +
            "      \"screen_name\": \"jm_let_me_luv_u\",\n" +
            "      \"location\": null,\n" +
            "      \"url\": null,\n" +
            "      \"description\": \"↺ \uD83C\uDF38\uD83D\uDCAB\uD83C\uDF38 ↺\",\n" +
            "      \"translator_type\": \"none\",\n" +
            "      \"protected\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"followers_count\": 25,\n" +
            "      \"friends_count\": 112,\n" +
            "      \"listed_count\": 0,\n" +
            "      \"favourites_count\": 7687,\n" +
            "      \"statuses_count\": 453,\n" +
            "      \"created_at\": \"Fri Jan 24 05:56:37 +0000 2020\",\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": false,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"profile_background_color\": \"F5F8FA\",\n" +
            "      \"profile_background_image_url\": \"\",\n" +
            "      \"profile_background_image_url_https\": \"\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_link_color\": \"1DA1F2\",\n" +
            "      \"profile_sidebar_border_color\": \"C0DEED\",\n" +
            "      \"profile_sidebar_fill_color\": \"DDEEF6\",\n" +
            "      \"profile_text_color\": \"333333\",\n" +
            "      \"profile_use_background_image\": true,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1253016335971348480/nmSH9fjf_normal.jpg\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1253016335971348480/nmSH9fjf_normal.jpg\",\n" +
            "      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/1220586138659934209/1587576470\",\n" +
            "      \"default_profile\": true,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"extended_tweet\": {\n" +
            "      \"full_text\": \"Girls don’t want boyfriends they want Huang Renjun in the second verse of Quiet Down\\n#RIDINwithNCTDREAM\\n#NCTDREAM_Ridin \\n#NCTDREAM_Reload https://t.co/uYGqsmslAA\",\n" +
            "      \"display_text_range\": [\n" +
            "        0,\n" +
            "        161\n" +
            "      ],\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"RIDINwithNCTDREAM\",\n" +
            "            \"indices\": [\n" +
            "              85,\n" +
            "              103\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"NCTDREAM_Ridin\",\n" +
            "            \"indices\": [\n" +
            "              104,\n" +
            "              119\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"NCTDREAM_Reload\",\n" +
            "            \"indices\": [\n" +
            "              121,\n" +
            "              137\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1255433308080668672,\n" +
            "            \"id_str\": \"1255433308080668672\",\n" +
            "            \"indices\": [\n" +
            "              138,\n" +
            "              161\n" +
            "            ],\n" +
            "            \"additional_media_info\": {\n" +
            "              \"monetizable\": false\n" +
            "            },\n" +
            "            \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1255433308080668672/pu/img/bAzBQu441I2HUF0X.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1255433308080668672/pu/img/bAzBQu441I2HUF0X.jpg\",\n" +
            "            \"url\": \"https://t.co/uYGqsmslAA\",\n" +
            "            \"display_url\": \"pic.twitter.com/uYGqsmslAA\",\n" +
            "            \"expanded_url\": \"https://twitter.com/forevernoren/status/1255433359469301761/video/1\",\n" +
            "            \"type\": \"video\",\n" +
            "            \"video_info\": {\n" +
            "              \"aspect_ratio\": [\n" +
            "                37,\n" +
            "                80\n" +
            "              ],\n" +
            "              \"duration_millis\": 6168,\n" +
            "              \"variants\": [\n" +
            "                {\n" +
            "                  \"bitrate\": 632000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/320x690/3PZoe-mWfkEL6eEv.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 832000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/360x778/b8LAW2YDAmWPAyzI.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 2176000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/592x1280/XBnrsz9dFem9W-Bt.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"content_type\": \"application/x-mpegURL\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/pl/aF1Bs9H23zwL-V5A.m3u8?tag=10\"\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 315,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 555,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 592,\n" +
            "                \"h\": 1280,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            },\n" +
            "            \"source_status_id\": 1255433359469301761,\n" +
            "            \"source_status_id_str\": \"1255433359469301761\",\n" +
            "            \"source_user_id\": 1003868144748752897,\n" +
            "            \"source_user_id_str\": \"1003868144748752897\"\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"extended_entities\": {\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1255433308080668672,\n" +
            "            \"id_str\": \"1255433308080668672\",\n" +
            "            \"indices\": [\n" +
            "              138,\n" +
            "              161\n" +
            "            ],\n" +
            "            \"additional_media_info\": {\n" +
            "              \"monetizable\": false\n" +
            "            },\n" +
            "            \"media_url\": \"http://pbs.twimg.com/ext_tw_video_thumb/1255433308080668672/pu/img/bAzBQu441I2HUF0X.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/ext_tw_video_thumb/1255433308080668672/pu/img/bAzBQu441I2HUF0X.jpg\",\n" +
            "            \"url\": \"https://t.co/uYGqsmslAA\",\n" +
            "            \"display_url\": \"pic.twitter.com/uYGqsmslAA\",\n" +
            "            \"expanded_url\": \"https://twitter.com/forevernoren/status/1255433359469301761/video/1\",\n" +
            "            \"type\": \"video\",\n" +
            "            \"video_info\": {\n" +
            "              \"aspect_ratio\": [\n" +
            "                37,\n" +
            "                80\n" +
            "              ],\n" +
            "              \"duration_millis\": 6168,\n" +
            "              \"variants\": [\n" +
            "                {\n" +
            "                  \"bitrate\": 632000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/320x690/3PZoe-mWfkEL6eEv.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 832000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/360x778/b8LAW2YDAmWPAyzI.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"bitrate\": 2176000,\n" +
            "                  \"content_type\": \"video/mp4\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/vid/592x1280/XBnrsz9dFem9W-Bt.mp4?tag=10\"\n" +
            "                },\n" +
            "                {\n" +
            "                  \"content_type\": \"application/x-mpegURL\",\n" +
            "                  \"url\": \"https://video.twimg.com/ext_tw_video/1255433308080668672/pu/pl/aF1Bs9H23zwL-V5A.m3u8?tag=10\"\n" +
            "                }\n" +
            "              ]\n" +
            "            },\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 315,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 555,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 592,\n" +
            "                \"h\": 1280,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            },\n" +
            "            \"source_status_id\": 1255433359469301761,\n" +
            "            \"source_status_id_str\": \"1255433359469301761\",\n" +
            "            \"source_user_id\": 1003868144748752897,\n" +
            "            \"source_user_id_str\": \"1003868144748752897\"\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    \"quote_count\": 0,\n" +
            "    \"reply_count\": 1,\n" +
            "    \"retweet_count\": 8,\n" +
            "    \"favorite_count\": 13,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [\n" +
            "        {\n" +
            "          \"text\": \"RIDINwithNCTDREAM\",\n" +
            "          \"indices\": [\n" +
            "            85,\n" +
            "            103\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"urls\": [\n" +
            "        {\n" +
            "          \"url\": \"https://t.co/qmlXiLhaiS\",\n" +
            "          \"expanded_url\": \"https://twitter.com/i/web/status/1255435450686345217\",\n" +
            "          \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "          \"indices\": [\n" +
            "            105,\n" +
            "            128\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"symbols\": []\n" +
            "    },\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"filter_level\": \"low\",\n" +
            "    \"lang\": \"en\",\n" +
            "    \"matching_rules\": [\n" +
            "      {\n" +
            "        \"tag\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    private static final String MSG4 = "{\n" +
            "  \"strategy_id\": 3,\n" +
            "  \"lang\": \"us\",\n" +
            "  \"place_country\": \"us\",\n" +
            "  \"collect_emotion\": true,\n" +
            "  \"collect_entity\": true,\n" +
            "  \"tweet\": {\n" +
            "    \"created_at\": \"Mon Apr 27 23:35:12 +0000 2020\",\n" +
            "    \"id\": 1254917041196318727,\n" +
            "    \"id_str\": \"1254917041196318727\",\n" +
            "    \"text\": \"Math Jam let's you collaborate on an online whiteboard just like you would in Google Docs. Free forever. Works for… https://t.co/uk1zDYuPFR\",\n" +
            "    \"display_text_range\": [\n" +
            "      0,\n" +
            "      140\n" +
            "    ],\n" +
            "    \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "    \"truncated\": true,\n" +
            "    \"in_reply_to_status_id\": null,\n" +
            "    \"in_reply_to_status_id_str\": null,\n" +
            "    \"in_reply_to_user_id\": null,\n" +
            "    \"in_reply_to_user_id_str\": null,\n" +
            "    \"in_reply_to_screen_name\": null,\n" +
            "    \"user\": {\n" +
            "      \"id\": 93908060,\n" +
            "      \"id_str\": \"93908060\",\n" +
            "      \"name\": \"Krista Marks\",\n" +
            "      \"screen_name\": \"kristamarks\",\n" +
            "      \"location\": \"Boulder, CO\",\n" +
            "      \"url\": \"http://www.wootmath.com\",\n" +
            "      \"description\": \"Passionate about helping all students experience the joy of math. Proud to lead the extraordinary humans @wootmath @woottutor\",\n" +
            "      \"translator_type\": \"none\",\n" +
            "      \"derived\": {\n" +
            "        \"locations\": [\n" +
            "          {\n" +
            "            \"country\": \"United States\",\n" +
            "            \"country_code\": \"US\",\n" +
            "            \"locality\": \"Boulder\",\n" +
            "            \"region\": \"Colorado\",\n" +
            "            \"sub_region\": \"Boulder County\",\n" +
            "            \"full_name\": \"Boulder, Colorado, United States\",\n" +
            "            \"geo\": {\n" +
            "              \"coordinates\": [\n" +
            "                -105.27055,\n" +
            "                40.01499\n" +
            "              ],\n" +
            "              \"type\": \"point\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"protected\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"followers_count\": 1233,\n" +
            "      \"friends_count\": 806,\n" +
            "      \"listed_count\": 125,\n" +
            "      \"favourites_count\": 15165,\n" +
            "      \"statuses_count\": 8058,\n" +
            "      \"created_at\": \"Tue Dec 01 17:57:48 +0000 2009\",\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": true,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"profile_background_color\": \"CCD6DD\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme18/bg.gif\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_link_color\": \"F37321\",\n" +
            "      \"profile_sidebar_border_color\": \"FFFFFF\",\n" +
            "      \"profile_sidebar_fill_color\": \"95E8EC\",\n" +
            "      \"profile_text_color\": \"3C3940\",\n" +
            "      \"profile_use_background_image\": true,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1226514421385613312/lItZk9Dw_normal.jpg\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1226514421385613312/lItZk9Dw_normal.jpg\",\n" +
            "      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/93908060/1521561880\",\n" +
            "      \"default_profile\": false,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"extended_tweet\": {\n" +
            "      \"full_text\": \"Math Jam let's you collaborate on an online whiteboard just like you would in Google Docs. Free forever. Works for teams of all sizes. Sign up and try @wootmath's #MathJam at: https://t.co/i7xWhzzeuu\\n#students #teachers #distancelearning https://t.co/2cTO6kVIry\",\n" +
            "      \"display_text_range\": [\n" +
            "        0,\n" +
            "        237\n" +
            "      ],\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"MathJam\",\n" +
            "            \"indices\": [\n" +
            "              163,\n" +
            "              171\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"students\",\n" +
            "            \"indices\": [\n" +
            "              200,\n" +
            "              209\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"teachers\",\n" +
            "            \"indices\": [\n" +
            "              210,\n" +
            "              219\n" +
            "            ]\n" +
            "          },\n" +
            "          {\n" +
            "            \"text\": \"distancelearning\",\n" +
            "            \"indices\": [\n" +
            "              220,\n" +
            "              237\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/i7xWhzzeuu\",\n" +
            "            \"expanded_url\": \"https://www.wootmath.com/\",\n" +
            "            \"display_url\": \"wootmath.com\",\n" +
            "            \"unwound\": {\n" +
            "              \"url\": \"https://www.wootmath.com/\",\n" +
            "              \"status\": 200,\n" +
            "              \"title\": \"Woot Math - Engaging, Research-based Tools for the Math Classroom\",\n" +
            "              \"description\": \"Woot Math provides engaging, research-based tools to help teachers reach more students and help all students deeply understand mathematics. Our teacher dashboard provides standards-aligned, printable reports to keep the teacher in the loop.\"\n" +
            "            },\n" +
            "            \"indices\": [\n" +
            "              176,\n" +
            "              199\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"wootmath\",\n" +
            "            \"name\": \"Woot Math\",\n" +
            "            \"id\": 1908248168,\n" +
            "            \"id_str\": \"1908248168\",\n" +
            "            \"indices\": [\n" +
            "              151,\n" +
            "              160\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"symbols\": [],\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1254916799432359938,\n" +
            "            \"id_str\": \"1254916799432359938\",\n" +
            "            \"indices\": [\n" +
            "              238,\n" +
            "              261\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EWpcLiTWAAIHHsN.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EWpcLiTWAAIHHsN.jpg\",\n" +
            "            \"url\": \"https://t.co/2cTO6kVIry\",\n" +
            "            \"display_url\": \"pic.twitter.com/2cTO6kVIry\",\n" +
            "            \"expanded_url\": \"https://twitter.com/kristamarks/status/1254917041196318727/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"medium\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"extended_entities\": {\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1254916799432359938,\n" +
            "            \"id_str\": \"1254916799432359938\",\n" +
            "            \"indices\": [\n" +
            "              238,\n" +
            "              261\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EWpcLiTWAAIHHsN.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EWpcLiTWAAIHHsN.jpg\",\n" +
            "            \"url\": \"https://t.co/2cTO6kVIry\",\n" +
            "            \"display_url\": \"pic.twitter.com/2cTO6kVIry\",\n" +
            "            \"expanded_url\": \"https://twitter.com/kristamarks/status/1254917041196318727/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"medium\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 680,\n" +
            "                \"h\": 378,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    \"quote_count\": 0,\n" +
            "    \"reply_count\": 0,\n" +
            "    \"retweet_count\": 4,\n" +
            "    \"favorite_count\": 7,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [],\n" +
            "      \"urls\": [\n" +
            "        {\n" +
            "          \"url\": \"https://t.co/uk1zDYuPFR\",\n" +
            "          \"expanded_url\": \"https://twitter.com/i/web/status/1254917041196318727\",\n" +
            "          \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "          \"indices\": [\n" +
            "            116,\n" +
            "            139\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"symbols\": []\n" +
            "    },\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"filter_level\": \"low\",\n" +
            "    \"lang\": \"en\",\n" +
            "    \"matching_rules\": [\n" +
            "      {\n" +
            "        \"tag\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";

    private static final String MSG5 = "{\n" +
            "  \"strategy_id\": 3,\n" +
            "  \"lang\": \"us\",\n" +
            "  \"place_country\": \"us\",\n" +
            "  \"collect_emotion\": true,\n" +
            "  \"collect_entity\": true,\n" +
            "  \"tweet\": {\n" +
            "    \"created_at\": \"Thu May 07 08:40:20 +0000 2020\",\n" +
            "    \"id\": 1258315717818056712,\n" +
            "    \"id_str\": \"1258315717818056712\",\n" +
            "    \"text\": \"\uD83D\uDCDD Always on Display:\\n\\nPour les appareils avec un affichage AMOLED, Xiaomi propose l'affichage ambiant avec une pers… https://t.co/yI812M98L7\",\n" +
            "    \"display_text_range\": [\n" +
            "      0,\n" +
            "      140\n" +
            "    ],\n" +
            "    \"source\": \"<a href=\\\"https://mobile.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Web App</a>\",\n" +
            "    \"truncated\": true,\n" +
            "    \"in_reply_to_status_id\": 1258315715666468867,\n" +
            "    \"in_reply_to_status_id_str\": \"1258315715666468867\",\n" +
            "    \"in_reply_to_user_id\": 887670056859176962,\n" +
            "    \"in_reply_to_user_id_str\": \"887670056859176962\",\n" +
            "    \"in_reply_to_screen_name\": \"FassTechFR\",\n" +
            "    \"user\": {\n" +
            "      \"id\": 887670056859176962,\n" +
            "      \"id_str\": \"887670056859176962\",\n" +
            "      \"name\": \"FassTech \uD83C\uDDEB\uD83C\uDDF7 | CEO TechSpeak\",\n" +
            "      \"screen_name\": \"FassTechFR\",\n" +
            "      \"location\": \"Moselle, France\",\n" +
            "      \"url\": \"https://www.instagram.com/fasstech_florian/\",\n" +
            "      \"description\": \"Passionné #Numérique\uD83D\uDCF1#Hardware\uD83D\uDCBB#Télécom\uD83D\uDEF0️#Photo\uD83D\uDCF8 19yo | J'aime découvrir de nouvelles choses et améliorer mes connaissances \uD83C\uDDEB\uD83C\uDDF7\uD83C\uDDEA\uD83C\uDDFA\uD83E\uDD56 #Xiaomi\uD83E\uDDE1\",\n" +
            "      \"translator_type\": \"none\",\n" +
            "      \"derived\": {\n" +
            "        \"locations\": [\n" +
            "          {\n" +
            "            \"country\": \"France\",\n" +
            "            \"country_code\": \"FR\",\n" +
            "            \"locality\": \"Châtel-sur-Moselle\",\n" +
            "            \"region\": \"Lorraine\",\n" +
            "            \"sub_region\": \"Département des Vosges\",\n" +
            "            \"full_name\": \"Châtel-sur-Moselle, Lorraine, France\",\n" +
            "            \"geo\": {\n" +
            "              \"coordinates\": [\n" +
            "                6.39403,\n" +
            "                48.3143\n" +
            "              ],\n" +
            "              \"type\": \"point\"\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"protected\": false,\n" +
            "      \"verified\": false,\n" +
            "      \"followers_count\": 635,\n" +
            "      \"friends_count\": 1243,\n" +
            "      \"listed_count\": 5,\n" +
            "      \"favourites_count\": 36113,\n" +
            "      \"statuses_count\": 32458,\n" +
            "      \"created_at\": \"Wed Jul 19 13:46:48 +0000 2017\",\n" +
            "      \"utc_offset\": null,\n" +
            "      \"time_zone\": null,\n" +
            "      \"geo_enabled\": false,\n" +
            "      \"lang\": null,\n" +
            "      \"contributors_enabled\": false,\n" +
            "      \"is_translator\": false,\n" +
            "      \"profile_background_color\": \"000000\",\n" +
            "      \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "      \"profile_background_tile\": false,\n" +
            "      \"profile_link_color\": \"19CF86\",\n" +
            "      \"profile_sidebar_border_color\": \"000000\",\n" +
            "      \"profile_sidebar_fill_color\": \"000000\",\n" +
            "      \"profile_text_color\": \"000000\",\n" +
            "      \"profile_use_background_image\": false,\n" +
            "      \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1252576257935642625/ILsRBhTH_normal.jpg\",\n" +
            "      \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1252576257935642625/ILsRBhTH_normal.jpg\",\n" +
            "      \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/887670056859176962/1588456601\",\n" +
            "      \"default_profile\": false,\n" +
            "      \"default_profile_image\": false,\n" +
            "      \"following\": null,\n" +
            "      \"follow_request_sent\": null,\n" +
            "      \"notifications\": null\n" +
            "    },\n" +
            "    \"geo\": null,\n" +
            "    \"coordinates\": null,\n" +
            "    \"place\": null,\n" +
            "    \"contributors\": null,\n" +
            "    \"is_quote_status\": false,\n" +
            "    \"extended_tweet\": {\n" +
            "      \"full_text\": \"\uD83D\uDCDD Always on Display:\\n\\nPour les appareils avec un affichage AMOLED, Xiaomi propose l'affichage ambiant avec une personnalisation et une variété que vous n'avez jamais vues sur aucun autre téléphone ! N'hésitez pas à créer votre propre design et à l'adapter à votre goût. \uD83D\uDD3D https://t.co/Rm19flN3nn\",\n" +
            "      \"display_text_range\": [\n" +
            "        0,\n" +
            "        271\n" +
            "      ],\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"urls\": [],\n" +
            "        \"user_mentions\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1258274598992465922,\n" +
            "            \"id_str\": \"1258274598992465922\",\n" +
            "            \"indices\": [\n" +
            "              272,\n" +
            "              295\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EXZKFMbX0AIVAz2.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EXZKFMbX0AIVAz2.jpg\",\n" +
            "            \"url\": \"https://t.co/Rm19flN3nn\",\n" +
            "            \"display_url\": \"pic.twitter.com/Rm19flN3nn\",\n" +
            "            \"expanded_url\": \"https://twitter.com/FassTechFR/status/1258315717818056712/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 314,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 945,\n" +
            "                \"h\": 2048,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 554,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1258274623717810176,\n" +
            "            \"id_str\": \"1258274623717810176\",\n" +
            "            \"indices\": [\n" +
            "              272,\n" +
            "              295\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EXZKGoiWoAAx-rv.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EXZKGoiWoAAx-rv.jpg\",\n" +
            "            \"url\": \"https://t.co/Rm19flN3nn\",\n" +
            "            \"display_url\": \"pic.twitter.com/Rm19flN3nn\",\n" +
            "            \"expanded_url\": \"https://twitter.com/FassTechFR/status/1258315717818056712/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 314,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 554,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 945,\n" +
            "                \"h\": 2048,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"extended_entities\": {\n" +
            "        \"media\": [\n" +
            "          {\n" +
            "            \"id\": 1258274598992465922,\n" +
            "            \"id_str\": \"1258274598992465922\",\n" +
            "            \"indices\": [\n" +
            "              272,\n" +
            "              295\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EXZKFMbX0AIVAz2.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EXZKFMbX0AIVAz2.jpg\",\n" +
            "            \"url\": \"https://t.co/Rm19flN3nn\",\n" +
            "            \"display_url\": \"pic.twitter.com/Rm19flN3nn\",\n" +
            "            \"expanded_url\": \"https://twitter.com/FassTechFR/status/1258315717818056712/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 314,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 945,\n" +
            "                \"h\": 2048,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 554,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          },\n" +
            "          {\n" +
            "            \"id\": 1258274623717810176,\n" +
            "            \"id_str\": \"1258274623717810176\",\n" +
            "            \"indices\": [\n" +
            "              272,\n" +
            "              295\n" +
            "            ],\n" +
            "            \"media_url\": \"http://pbs.twimg.com/media/EXZKGoiWoAAx-rv.jpg\",\n" +
            "            \"media_url_https\": \"https://pbs.twimg.com/media/EXZKGoiWoAAx-rv.jpg\",\n" +
            "            \"url\": \"https://t.co/Rm19flN3nn\",\n" +
            "            \"display_url\": \"pic.twitter.com/Rm19flN3nn\",\n" +
            "            \"expanded_url\": \"https://twitter.com/FassTechFR/status/1258315717818056712/photo/1\",\n" +
            "            \"type\": \"photo\",\n" +
            "            \"sizes\": {\n" +
            "              \"thumb\": {\n" +
            "                \"w\": 150,\n" +
            "                \"h\": 150,\n" +
            "                \"resize\": \"crop\"\n" +
            "              },\n" +
            "              \"small\": {\n" +
            "                \"w\": 314,\n" +
            "                \"h\": 680,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"medium\": {\n" +
            "                \"w\": 554,\n" +
            "                \"h\": 1200,\n" +
            "                \"resize\": \"fit\"\n" +
            "              },\n" +
            "              \"large\": {\n" +
            "                \"w\": 945,\n" +
            "                \"h\": 2048,\n" +
            "                \"resize\": \"fit\"\n" +
            "              }\n" +
            "            }\n" +
            "          }\n" +
            "        ]\n" +
            "      }\n" +
            "    },\n" +
            "    \"quote_count\": 0,\n" +
            "    \"reply_count\": 1,\n" +
            "    \"retweet_count\": 0,\n" +
            "    \"favorite_count\": 0,\n" +
            "    \"entities\": {\n" +
            "      \"hashtags\": [],\n" +
            "      \"urls\": [\n" +
            "        {\n" +
            "          \"url\": \"https://t.co/yI812M98L7\",\n" +
            "          \"expanded_url\": \"https://twitter.com/i/web/status/1258315717818056712\",\n" +
            "          \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "          \"indices\": [\n" +
            "            117,\n" +
            "            140\n" +
            "          ]\n" +
            "        }\n" +
            "      ],\n" +
            "      \"user_mentions\": [],\n" +
            "      \"symbols\": []\n" +
            "    },\n" +
            "    \"favorited\": false,\n" +
            "    \"retweeted\": false,\n" +
            "    \"possibly_sensitive\": false,\n" +
            "    \"filter_level\": \"low\",\n" +
            "    \"lang\": \"fr\",\n" +
            "    \"matching_rules\": [\n" +
            "      {\n" +
            "        \"tag\": null\n" +
            "      }\n" +
            "    ]\n" +
            "  }\n" +
            "}";
}

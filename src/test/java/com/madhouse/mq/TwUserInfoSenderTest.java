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
 * @date: 2020-04-26 11:50
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class TwUserInfoSenderTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void sendTweetMsg() {
        this.rabbitTemplate.setExchange("tw.user_info.exchange");
        this.rabbitTemplate.setRoutingKey("tw.user_info.routing.key");
        Message message = MessageBuilder.withBody(MSG2.getBytes(StandardCharsets.UTF_8)).setDeliveryMode(MessageDeliveryMode.PERSISTENT).build();
        this.rabbitTemplate.send(message);
    }

    private static final String MSG ="{\n" +
            "  \"strategyId\": 1,\n" +
            "  \"user\": {\n" +
            "    \"id\": 515343847,\n" +
            "    \"id_str\": \"515343847\",\n" +
            "    \"name\": \"Mégane Chiecchi\",\n" +
            "    \"screen_name\": \"meganechiecchi\",\n" +
            "    \"location\": \"France\",\n" +
            "    \"profile_location\": {\n" +
            "      \"id\": \"f3bfc7dcc928977f\",\n" +
            "      \"url\": \"https://api.twitter.com/1.1/geo/id/f3bfc7dcc928977f.json\",\n" +
            "      \"place_type\": \"unknown\",\n" +
            "      \"name\": \"France\",\n" +
            "      \"full_name\": \"France\",\n" +
            "      \"country_code\": \"\",\n" +
            "      \"country\": \"\",\n" +
            "      \"contained_within\": [],\n" +
            "      \"bounding_box\": null,\n" +
            "      \"attributes\": {}\n" +
            "    },\n" +
            "    \"description\": \"Journaliste vidéo au pôle multimédia @LePoint\",\n" +
            "    \"url\": \"https://t.co/u2Lp1cj7MN\",\n" +
            "    \"entities\": {\n" +
            "      \"url\": {\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/u2Lp1cj7MN\",\n" +
            "            \"expanded_url\": \"http://bit.ly/2TnBcp9\",\n" +
            "            \"display_url\": \"bit.ly/2TnBcp9\",\n" +
            "            \"indices\": [\n" +
            "              0,\n" +
            "              23\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"description\": {\n" +
            "        \"urls\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"protected\": false,\n" +
            "    \"followers_count\": 552,\n" +
            "    \"friends_count\": 602,\n" +
            "    \"listed_count\": 26,\n" +
            "    \"created_at\": \"Mon Mar 05 10:50:36 +0000 2012\",\n" +
            "    \"favourites_count\": 1437,\n" +
            "    \"utc_offset\": null,\n" +
            "    \"time_zone\": null,\n" +
            "    \"geo_enabled\": true,\n" +
            "    \"verified\": false,\n" +
            "    \"statuses_count\": 4355,\n" +
            "    \"lang\": null,\n" +
            "    \"status\": {\n" +
            "      \"created_at\": \"Fri Apr 24 14:56:04 +0000 2020\",\n" +
            "      \"id\": 1253699233615687680,\n" +
            "      \"id_str\": \"1253699233615687680\",\n" +
            "      \"text\": \"RT @LePoint: « La santé est entre les mains des financiers »\\nL'ancien directeur des Hôpitaux Jean de Kervasdoué passe le système français a…\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"LePoint\",\n" +
            "            \"name\": \"Le Point\",\n" +
            "            \"id\": 8460572,\n" +
            "            \"id_str\": \"8460572\",\n" +
            "            \"indices\": [\n" +
            "              3,\n" +
            "              11\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": []\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\n" +
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
            "        \"created_at\": \"Fri Apr 24 14:55:33 +0000 2020\",\n" +
            "        \"id\": 1253699102182985731,\n" +
            "        \"id_str\": \"1253699102182985731\",\n" +
            "        \"text\": \"« La santé est entre les mains des financiers »\\nL'ancien directeur des Hôpitaux Jean de Kervasdoué passe le système… https://t.co/GOqiqKIIzx\",\n" +
            "        \"truncated\": true,\n" +
            "        \"entities\": {\n" +
            "          \"hashtags\": [],\n" +
            "          \"symbols\": [],\n" +
            "          \"user_mentions\": [],\n" +
            "          \"urls\": [\n" +
            "            {\n" +
            "              \"url\": \"https://t.co/GOqiqKIIzx\",\n" +
            "              \"expanded_url\": \"https://twitter.com/i/web/status/1253699102182985731\",\n" +
            "              \"display_url\": \"twitter.com/i/web/status/1…\",\n" +
            "              \"indices\": [\n" +
            "                117,\n" +
            "                140\n" +
            "              ]\n" +
            "            }\n" +
            "          ]\n" +
            "        },\n" +
            "        \"source\": \"<a href=\\\"https://studio.twitter.com\\\" rel=\\\"nofollow\\\">Twitter Media Studio</a>\",\n" +
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
            "        \"retweet_count\": 28,\n" +
            "        \"favorite_count\": 20,\n" +
            "        \"favorited\": false,\n" +
            "        \"retweeted\": false,\n" +
            "        \"possibly_sensitive\": false,\n" +
            "        \"lang\": \"fr\"\n" +
            "      },\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 28,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"lang\": \"fr\"\n" +
            "    },\n" +
            "    \"contributors_enabled\": false,\n" +
            "    \"is_translator\": false,\n" +
            "    \"is_translation_enabled\": false,\n" +
            "    \"profile_background_color\": \"352726\",\n" +
            "    \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme5/bg.gif\",\n" +
            "    \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme5/bg.gif\",\n" +
            "    \"profile_background_tile\": false,\n" +
            "    \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1069904744272011264/sXCSowmq_normal.jpg\",\n" +
            "    \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1069904744272011264/sXCSowmq_normal.jpg\",\n" +
            "    \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/515343847/1481108243\",\n" +
            "    \"profile_link_color\": \"D02B55\",\n" +
            "    \"profile_sidebar_border_color\": \"829D5E\",\n" +
            "    \"profile_sidebar_fill_color\": \"99CC33\",\n" +
            "    \"profile_text_color\": \"3E4415\",\n" +
            "    \"profile_use_background_image\": true,\n" +
            "    \"has_extended_profile\": false,\n" +
            "    \"default_profile\": false,\n" +
            "    \"default_profile_image\": false,\n" +
            "    \"following\": null,\n" +
            "    \"follow_request_sent\": null,\n" +
            "    \"notifications\": null,\n" +
            "    \"translator_type\": \"none\"\n" +
            "  }\n" +
            "}";

    private static final String MSG2="{\n" +
            "  \"strategyId\": 2,\n" +
            "  \"user\": {\n" +
            "    \"id\": 168987238,\n" +
            "    \"id_str\": \"168987238\",\n" +
            "    \"name\": \"加藤莉子\uD83C\uDDEF\uD83C\uDDF5\uD83C\uDDE8\uD83C\uDDED\uD83C\uDDE9\uD83C\uDDEA\uD83C\uDDEB\uD83C\uDDF7\uD83C\uDDE8\uD83C\uDDE6が大好きだ♥♥\",\n" +
            "    \"screen_name\": \"ps90675\",\n" +
            "    \"location\": \"\",\n" +
            "    \"profile_location\": null,\n" +
            "    \"description\": \"大切なのはどんな選択をするかじゃない！自分が選択した人生を強く生きるかどうか！ただそれだけだ｡\",\n" +
            "    \"url\": null,\n" +
            "    \"entities\": {\n" +
            "      \"description\": {\n" +
            "        \"urls\": []\n" +
            "      }\n" +
            "    },\n" +
            "    \"protected\": false,\n" +
            "    \"followers_count\": 249,\n" +
            "    \"friends_count\": 559,\n" +
            "    \"listed_count\": 4,\n" +
            "    \"created_at\": \"Wed Jul 21 07:33:33 +0000 2010\",\n" +
            "    \"favourites_count\": 50780,\n" +
            "    \"utc_offset\": null,\n" +
            "    \"time_zone\": null,\n" +
            "    \"geo_enabled\": false,\n" +
            "    \"verified\": false,\n" +
            "    \"statuses_count\": 29734,\n" +
            "    \"lang\": null,\n" +
            "    \"status\": {\n" +
            "      \"created_at\": \"Sun Apr 26 07:19:08 +0000 2020\",\n" +
            "      \"id\": 1254309018606006272,\n" +
            "      \"id_str\": \"1254309018606006272\",\n" +
            "      \"text\": \"RT @QuizKnock: 【1日5分！日々のプチ英語学習記事⑦】\\n\\n受験英単語はまだ序の口。我々はようやくのぼりはじめたばかりだからな、このはてしなく遠い英単語坂をよ…\\nhttps://t.co/s1apRRtlYg\\n\\n#QK週替わり特集\",\n" +
            "      \"truncated\": false,\n" +
            "      \"entities\": {\n" +
            "        \"hashtags\": [\n" +
            "          {\n" +
            "            \"text\": \"QK週替わり特集\",\n" +
            "            \"indices\": [\n" +
            "              112,\n" +
            "              121\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"symbols\": [],\n" +
            "        \"user_mentions\": [\n" +
            "          {\n" +
            "            \"screen_name\": \"QuizKnock\",\n" +
            "            \"name\": \"QuizKnock/クイズノック\",\n" +
            "            \"id\": 778927219422797824,\n" +
            "            \"id_str\": \"778927219422797824\",\n" +
            "            \"indices\": [\n" +
            "              3,\n" +
            "              13\n" +
            "            ]\n" +
            "          }\n" +
            "        ],\n" +
            "        \"urls\": [\n" +
            "          {\n" +
            "            \"url\": \"https://t.co/s1apRRtlYg\",\n" +
            "            \"expanded_url\": \"https://quizknock.com/math-english\",\n" +
            "            \"display_url\": \"quizknock.com/math-english\",\n" +
            "            \"indices\": [\n" +
            "              87,\n" +
            "              110\n" +
            "            ]\n" +
            "          }\n" +
            "        ]\n" +
            "      },\n" +
            "      \"source\": \"<a href=\\\"http://twitter.com/download/android\\\" rel=\\\"nofollow\\\">Twitter for Android</a>\",\n" +
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
            "        \"created_at\": \"Sun Apr 26 02:55:00 +0000 2020\",\n" +
            "        \"id\": 1254242545606877185,\n" +
            "        \"id_str\": \"1254242545606877185\",\n" +
            "        \"text\": \"【1日5分！日々のプチ英語学習記事⑦】\\n\\n受験英単語はまだ序の口。我々はようやくのぼりはじめたばかりだからな、このはてしなく遠い英単語坂をよ…\\nhttps://t.co/s1apRRtlYg\\n\\n#QK週替わり特集\",\n" +
            "        \"truncated\": false,\n" +
            "        \"entities\": {\n" +
            "          \"hashtags\": [\n" +
            "            {\n" +
            "              \"text\": \"QK週替わり特集\",\n" +
            "              \"indices\": [\n" +
            "                97,\n" +
            "                106\n" +
            "              ]\n" +
            "            }\n" +
            "          ],\n" +
            "          \"symbols\": [],\n" +
            "          \"user_mentions\": [],\n" +
            "          \"urls\": [\n" +
            "            {\n" +
            "              \"url\": \"https://t.co/s1apRRtlYg\",\n" +
            "              \"expanded_url\": \"https://quizknock.com/math-english\",\n" +
            "              \"display_url\": \"quizknock.com/math-english\",\n" +
            "              \"indices\": [\n" +
            "                72,\n" +
            "                95\n" +
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
            "        \"retweet_count\": 74,\n" +
            "        \"favorite_count\": 1406,\n" +
            "        \"favorited\": false,\n" +
            "        \"retweeted\": false,\n" +
            "        \"possibly_sensitive\": false,\n" +
            "        \"lang\": \"ja\"\n" +
            "      },\n" +
            "      \"is_quote_status\": false,\n" +
            "      \"retweet_count\": 74,\n" +
            "      \"favorite_count\": 0,\n" +
            "      \"favorited\": false,\n" +
            "      \"retweeted\": false,\n" +
            "      \"possibly_sensitive\": false,\n" +
            "      \"lang\": \"ja\"\n" +
            "    },\n" +
            "    \"contributors_enabled\": false,\n" +
            "    \"is_translator\": false,\n" +
            "    \"is_translation_enabled\": false,\n" +
            "    \"profile_background_color\": \"000000\",\n" +
            "    \"profile_background_image_url\": \"http://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "    \"profile_background_image_url_https\": \"https://abs.twimg.com/images/themes/theme1/bg.png\",\n" +
            "    \"profile_background_tile\": false,\n" +
            "    \"profile_image_url\": \"http://pbs.twimg.com/profile_images/1157332244643508224/EZcb3qX6_normal.png\",\n" +
            "    \"profile_image_url_https\": \"https://pbs.twimg.com/profile_images/1157332244643508224/EZcb3qX6_normal.png\",\n" +
            "    \"profile_banner_url\": \"https://pbs.twimg.com/profile_banners/168987238/1537877129\",\n" +
            "    \"profile_link_color\": \"91D2FA\",\n" +
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

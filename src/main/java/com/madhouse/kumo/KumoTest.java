package com.madhouse.kumo;

import com.kennycason.kumo.CollisionMode;
import com.kennycason.kumo.WordCloud;
import com.kennycason.kumo.WordFrequency;
import com.kennycason.kumo.bg.CircleBackground;
import com.kennycason.kumo.bg.PixelBoundryBackground;
import com.kennycason.kumo.bg.RectangleBackground;
import com.kennycason.kumo.font.KumoFont;
import com.kennycason.kumo.font.scale.SqrtFontScalar;
import com.kennycason.kumo.nlp.FrequencyAnalyzer;
import com.kennycason.kumo.palette.LinearGradientColorPalette;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-11 15:17
 */
public class KumoTest {
    public static void main(String[] args) throws IOException {
        String text = "@heartAcat85 Your mind's in the right place. We've made sure to take your feedback to our team.@TheRealCDaddy Unfortunately, The Nike Polo (CJ0880-010) is completely sold out at this time. Stay tuned for any po… https://t.co/1WAKgOU7IK.@MichaelSmock1 Heat wave. \uD83D\uDD25";
//建立词频分析器，设置词频，以及词语最短长度，此处的参数配置视情况而定即可
        FrequencyAnalyzer frequencyAnalyzer = new FrequencyAnalyzer();
        frequencyAnalyzer.setWordFrequenciesToReturn(600);
        frequencyAnalyzer.setMinWordLength(2);

        //引入中文解析器
//        frequencyAnalyzer.setWordTokenizer();
        //指定文本文件路径，生成词频集合
        final List<WordFrequency> wordFrequencyList = frequencyAnalyzer.load(new ByteArrayInputStream(text.getBytes()));
        //设置图片分辨率
        Dimension dimension = new Dimension(1000, 500);
        //此处的设置采用内置常量即可，生成词云对象
        WordCloud wordCloud = new WordCloud(dimension, CollisionMode.RECTANGLE);
        //设置边界及字体
        wordCloud.setPadding(2);
        java.awt.Font font = new java.awt.Font("STSong-Light", 3, 20);
        //设置词云显示的三种颜色，越靠前设置表示词频越高的词语的颜色
        wordCloud.setColorPalette(new LinearGradientColorPalette(Color.RED, Color.BLUE, Color.GREEN, 30, 30));
        wordCloud.setKumoFont(new KumoFont(font));
        //设置背景色
        wordCloud.setBackgroundColor(new Color(252, 238, 255));
        //设置背景图片
//        wordCloud.setBackground(new PixelBoundryBackground("/Users/apple/Desktop/social_twitter_seq.png"));
        //设置背景图层为圆形
//        wordCloud.setBackground(new CircleBackground(255));
        wordCloud.setBackground(new RectangleBackground(new Dimension(600,400)));
        wordCloud.setFontScalar(new SqrtFontScalar(12, 45));
        //生成词云
        wordCloud.build(wordFrequencyList);
        wordCloud.writeToFile("./wy.png");
    }
}

package com.madhouse.analyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.wltea.analyzer.lucene.IKAnalyzer;

import java.io.IOException;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-10 14:40
 */
public class AnalyzerTest1 {
    public static void main(String[] args) throws IOException {
        //1.创建一个Analyzer对象
        Analyzer analyzer=new IKAnalyzer();
        //2.调用Analyzer对象的tokenStream方法获取TokenStream对象，此对象包含了所有的分词结果
        TokenStream tokenStream = analyzer.tokenStream("", "安装mysql-5.7.22-winx64后数据库服务启动报错：本地计算机上的mysql服务启动停止后，某些服务未由其他服务或程序使用时将自动停止而且mysql官网下载的压缩包解压出来没有网线上安装教... 博文 来自： 测试菜鸟在路上，呵呵");
        //3.给tokenStream对象设置一个指针，指针在哪当前就在哪一个分词上
        CharTermAttribute charTermAttribute = tokenStream.addAttribute(CharTermAttribute.class);
        //4.调用tokenStream对象的reset方法，重置指针，不调用会报错
        tokenStream.reset();
        //5.利用while循环，拿到分词列表的结果  incrementToken方法返回值如果为false代表读取完毕  true代表没有读取完毕
        while (tokenStream.incrementToken()){
            System.out.println(charTermAttribute.toString());
        }
        //6.关闭
        tokenStream.close();
    }
}

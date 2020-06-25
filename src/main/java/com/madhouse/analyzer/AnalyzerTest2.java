package com.madhouse.analyzer;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import org.wltea.analyzer.core.IKSegmenter;
import org.wltea.analyzer.core.Lexeme;

import java.io.IOException;
import java.io.StringReader;
import java.util.Map;

/**
 * @desc:
 * @author: yuxinsheng
 * @date: 2020-06-10 15:55
 */
public class AnalyzerTest2 {
    public static void main(String[] args) throws IOException {
        String text = "我们都是中国人,我们都爱我们的祖国";
        Map<String, Integer> map = Maps.newHashMap();
        IKSegmenter ikSegmenter = new IKSegmenter(new StringReader(text), true);
        Lexeme lexeme;
        while ((lexeme = ikSegmenter.next()) != null) {
            String lexemeText = lexeme.getLexemeText();
            if (lexemeText.length() > 1) {
                if (map.containsKey(lexemeText)) {
                    map.put(lexemeText, map.get(lexemeText) + 1);
                } else {
                    map.put(lexemeText, 1);
                }
            }
        }
        System.out.println(JSON.toJSONString(map));
    }

}

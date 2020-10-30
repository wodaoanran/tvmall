package cn.yunhe.java;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JSoupTest {

    @Test
    public void mytest() throws IOException {
        Document doc = Jsoup.connect("http://www16.zzu.edu.cn/msgs/vmsgisapi.dll/vmsglist?mtype=m&lan=105").get();

        Element newsHeadlines = doc.selectFirst(".zzj_5");

        Elements headLines = newsHeadlines.select(".zzj_5a");
         Map<String,String> rtnMap = new HashMap<>();
        for(Element item : headLines){
            String value = item.selectFirst("a").attr("href");
            Element spanItem = item.selectFirst("span");
            String key = spanItem.text();

            rtnMap.put(key,value);
        }
        System.out.println(rtnMap);


    }
}

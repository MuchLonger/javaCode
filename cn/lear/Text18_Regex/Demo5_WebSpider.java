package cn.lear.Text18_Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @description: 网络爬虫测试（取出链接）
 * @Time: 2018/8/27 11:34
 */
public class Demo5_WebSpider {
    /*            获得指定的URL的源码内容，参数2是解码方式              */
    public static String getURLContent(String urlStr, String charset) {
        StringBuilder sb = new StringBuilder();
        //取出网址
        try {
            URL url = new URL(urlStr);

            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(),charset));
            String temp = "";
            while ((temp = br.readLine()) != null) {
                sb.append(temp);
                sb.append("\t\n");
            }


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //StringBuilder 得用toString
        return sb.toString();
    }


    public static void main(String[] args) {
        String destStr=getURLContent("http://www.163.com","gbk");
        /*            查找网址              */
        Pattern p=Pattern.compile("(?<=href=\")http[s]{0,1}://(\\w+\\.){1,}[a-zA-Z0-9]+/{0,1}([a-zA-Z0-9]{0,}+){0,}+/{0,1}([a-zA-Z0-9]+){0,1}/{0,1}");
        /*            进入查找              */
        Matcher m=p.matcher(destStr);

        while(m.find()){
            System.out.println(m.group());
        }

    }


}

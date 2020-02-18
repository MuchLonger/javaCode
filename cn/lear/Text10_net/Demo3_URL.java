package cn.lear.Text10_net;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * @description:    URL练习
 * @Time: 2018/8/17 12:18
 */
public class Demo3_URL {
    public static void main(String[] args) throws MalformedURLException {
        //绝对路径构建url
        URL url=new URL("http://www.baidu.com/index.html#aa?uname=cqy");
        System.out.println("名称:"+url.toString());
        System.out.println("协议:"+url.getProtocol());
        System.out.println("域名:"+url.getHost());
        System.out.println("端口:"+url.getPort());
        System.out.println("资源:"+url.getFile());
        System.out.println("相对路径:"+url.getPath());//较上面常用
        System.out.println("锚点:"+url.getRef());
        //下面的返回用户的参数，如果有锚点会返回null，如果没有回正确返回
        System.out.println("参数:"+url.getQuery());

        //相对路径构建url
        url=new URL("http://www.baidu.com/a/");
        url=new URL(url,"b.txt");
        System.out.println(url.toString());


    }
}

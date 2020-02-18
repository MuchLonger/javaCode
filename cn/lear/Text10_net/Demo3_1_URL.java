package cn.lear.Text10_net;

import java.io.*;
import java.net.URL;

/**
 * @description:
 * @Time: 2018/8/17 12:36
 */
public class Demo3_1_URL {
    public static void main(String[] args) throws IOException {
        URL url=new URL("http://www.baidu.com");        //主页

       /*
        //获取资源 网络流
        InputStream is=url.openStream();
        byte[] flush=new byte[1024];
        int len=0;
        while((len=is.read(flush))!=-1){
            System.out.println(new String(flush,0,len ));       //输出的是html、css、js
        }
        is.close();
        */

       //另外一种方法，转化格式的,并将其复制到指定的文件上。字符流
        BufferedReader br=new BufferedReader(
                new InputStreamReader(
                        url.openStream(),"UTF-8"));

        BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream("baidu.html"),"UTF-8"
                )
        );

        String msg=null;
        while((msg=br.readLine())!=null){
            bw.append(msg);
        }

        bw.flush();

        bw.close();
        br.close();


    }
}

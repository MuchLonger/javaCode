package cn.lear.Text10_net;

import java.net.Inet4Address;
import java.net.UnknownHostException;

/**
 * @description:  net方法练习,没有端口
 * @Time: 2018/8/17 11:42
 */
public class Demo1_Inet {

    public static void main(String[] args) throws UnknownHostException {
        //获得当前主机InetAddress对象
        Inet4Address addr= (Inet4Address) Inet4Address.getLocalHost();
        System.out.println(addr.getHostAddress());      //返回当前ip地址
        System.out.println(addr.getHostName());     //输出计算机名

        //通过域名得到对象
        addr= (Inet4Address) Inet4Address.getByName("www.baidu.com");
        System.out.println(addr.getHostAddress());  //返回ip
        System.out.println(addr.getHostName());     //返回域名

        //通过ip得到对象
        addr= (Inet4Address) Inet4Address.getByName("183.232.231.172");
        System.out.println(addr.getHostAddress());  //返回ip
        System.out.println(addr.getHostName());     //如果dns能解析则返回域名，否则返回ip


    }


}

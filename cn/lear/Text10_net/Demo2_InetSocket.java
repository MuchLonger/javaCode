package cn.lear.Text10_net;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

/**
 * @description: InetSocketAddress练习，有端口
 * @Time: 2018/8/17 11:51
 */
public class Demo2_InetSocket {


    public static void main(String[] args) throws UnknownHostException {
        //通过ip地址
        //InetSocketAddress isa=new InetSocketAddress("192.168.0.109",9999);  //不同的构造方法

        //通过主机名创建对象,InetAddress没有获得ip的方法
        InetSocketAddress isa = new InetSocketAddress(InetAddress.getLocalHost(), 9999);  //不同的构造方法

        System.out.println(isa.getHostName());
        System.out.println(isa.getPort());

        InetAddress addr = isa.getAddress();      //利用地址创建对象

        System.out.println(addr.getHostAddress());
        System.out.println(addr.getHostName());

    }

}

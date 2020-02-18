package cn.lear.Text10_net;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @description: UDP模拟练习，，服务器端
 * @Time: 2018/8/17 14:57
 */
public class Demo4_1_UDP {
    //程序运行后会等待数据的传输
    public static void main(String[] args) throws IOException {
        //指定一个端口
        DatagramSocket ds = new DatagramSocket(9027);     //异常是指端口可能被占用
        //准备接受的容器
        byte[] container = new byte[1024];
        //封装成包，将容器及容器的长度放进去
        DatagramPacket packet = new DatagramPacket(container, container.length);
        //接受数据，字节数组 -->double类型
        ds.receive(packet);
        //分析数据

        /*  这是String转化的
        byte[] data = packet.getData();       //DatagramPacket内的方法
        int len = packet.getLength();
        System.out.println(new String(data, 0, len));
        */

        //这是data转Double，changer在下面
        System.out.println(changer(packet.getData()));

        ds.close();

    }

    //转换为double类型   double --> byte 输入流
    public static double changer(byte[] data) throws IOException {
        DataInputStream dis = new DataInputStream(
                new ByteArrayInputStream(
                        data
                )
        );

        double num = dis.readDouble();      //上面有data了，直接readDouble读出Double类型

        dis.close();
        return num;
    }


}

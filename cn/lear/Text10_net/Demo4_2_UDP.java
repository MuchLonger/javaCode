package cn.lear.Text10_net;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;

/**
 * @description:  UDP模拟练习，，客户端
 * @Time: 2018/8/17 14:57
 */
public class Demo4_2_UDP {

    public static void main(String[] args) throws IOException {
        //同客户端创建，当因为是同一台电脑所以注意端口号不要冲突了。
        DatagramSocket ds=new DatagramSocket(6666);
        //准备数据
        double msg=89.12;
        //转成字节数组，convert在下面
        byte[] data=convert(msg);
        //打包(需要加上发送的地点（服务器），及端口）
        DatagramPacket dp=new DatagramPacket(data, data.length, new InetSocketAddress(
                InetAddress.getLocalHost(),9027) {
        });
        //发送，double --> 字节数组
        ds.send(dp);
        //释放
        ds.close();

    }
    //double类型转成byte数组，byte --> double 输出流
    public static byte[] convert(double num) throws IOException {
        byte[] data=null;
        //因为下面还要获取数据，所以不将下面两句合并
        ByteArrayOutputStream baos=new ByteArrayOutputStream();
        DataOutputStream dos=new DataOutputStream(baos);

        dos.writeDouble(num);
        dos.flush();

        //获得数据
        data=baos.toByteArray();

        //只关dos，ByteArrayOutputStream先不关
        dos.close();

        return data;
    }


}

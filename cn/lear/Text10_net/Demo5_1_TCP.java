package cn.lear.Text10_net;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description:    TCP练习，，Client 客户端
 * @Time: 2018/8/17 17:31
 */
public class Demo5_1_TCP {

    // 创建客户端，必须指定服务器和端口
    public static void main(String[] args) throws IOException {
        Socket client=new Socket(InetAddress.getLocalHost(),9028);//端口号是服务器端口号

        /*
        方法一：
        //接收数据
        BufferedReader br=new BufferedReader(
                new InputStreamReader(
                        client.getInputStream()
                )
        );
        System.out.println(br.readLine());
        */

        //方法二：
        //接收数据的另外一种方法
        DataInputStream dis=new DataInputStream(client.getInputStream());
        System.out.println(dis.readUTF());  //获取服务器端写入的流

    }

}

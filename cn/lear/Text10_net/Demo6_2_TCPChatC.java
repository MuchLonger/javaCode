package cn.lear.Text10_net;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @description: 模拟聊天室练习，，客户端: 可发送数据与接收数据
 * @Time: 2018/8/17 18:25
 */
public class Demo6_2_TCPChatC {

    public static void main(String[] args) throws IOException {
        //创建名称
        System.out.println("请输入用户名： ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String name = br.readLine();
        //不为空
        if (name.equals("")) {
            return;
        }


        //创建客户端，使用服务器端IP和端口
        Socket client = new Socket(InetAddress.getLocalHost(), 9029);

        //调用send线程，其中一条路径
        new Thread(new Demo6_3_ChatSend(client, name)).start();

        //调用receive线程，另外一条路径
        new Thread(new Demo6_3_ChatReceive(client)).start();


    }


}

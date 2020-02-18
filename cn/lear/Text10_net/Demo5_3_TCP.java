package cn.lear.Text10_net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:  TCP练习，，利用while(true)死循环创建多个客户端。Server 服务器端
 * @Time: 2018/8/17 17:31
 */
public class Demo5_3_TCP {


    public static void main(String[] args) throws IOException {
        // 创建服务器，并指定端口
        ServerSocket server=new ServerSocket(9028)
                ;
        while(true) {       //创建死循环  有一个accept(),就有一个客户端，可以实现多个客户端

            // 接收客户端连接  阻塞式。如果没有接收到客户端就不会往下执行
            Socket socket = server.accept();        //返回一个socket
            System.out.println("一个已连接");
            //发送数据
            String msg = "cqy真帅";

            // 输出数据，另外一种方法
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            dos.writeUTF(msg);  //写入流，这样在客户端的inputStream内就能获取到该流的数值
            dos.flush();
        }



    }

}

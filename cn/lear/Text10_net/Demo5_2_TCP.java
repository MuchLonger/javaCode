package cn.lear.Text10_net;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @description:  TCP练习，，Server 服务器端
 * @Time: 2018/8/17 17:31
 */
public class Demo5_2_TCP {


    public static void main(String[] args) throws IOException {
        // 创建服务器，并指定端口
        ServerSocket server=new ServerSocket(9027);
        // 接收客户端连接  阻塞式。如果没有接收到客户端就不会往下执行
        Socket socket=server.accept();        //返回一个socket
        //发送数据
        String msg="cqy真帅";

        /*
        //获取输出流
        BufferedWriter bw=new BufferedWriter(
                new OutputStreamWriter(
                        socket.getOutputStream()
                )
        );      //文本
        bw.write(msg);
        bw.newLine();   //另起一行让客户端里的readLine可以读取到结束符。
        bw.flush();
        //不用关闭，不然服务器也会关闭
        */

        // 输出数据，另外一种方法
        DataOutputStream dos=new DataOutputStream(socket.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();




    }

}

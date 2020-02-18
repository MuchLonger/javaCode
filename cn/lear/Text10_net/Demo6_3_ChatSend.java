package cn.lear.Text10_net;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

/**
 * @description: 信息发送类（线程），将信息发送到服务器端
 * @Time: 2018/8/17 19:00
 */
public class Demo6_3_ChatSend implements Runnable {
    private BufferedReader br;  //实现输入
    private DataOutputStream dos;   //实现发送
    private boolean isRunning = true;        //线程是否运行中
    private String name;        //名称


    //构造函数初始化
    public Demo6_3_ChatSend() {
        br = new BufferedReader(
                new InputStreamReader(System.in)
        );     //默认就能输入输出
    }

    //构造函数初始化
    public Demo6_3_ChatSend(Socket socket, String name) {
        this();
        this.name = name;
        try {
            dos = new DataOutputStream(socket.getOutputStream());     //接收传进来的内容
            //在这里直接将name send给服务器，服务器先处理，之后才到run方法，且得出结论：只要dos流write了之后服务器就会立刻读取
            send(name);
        } catch (IOException e) {       //if an I/O error occurs when creating the output stream or if the socket is not connected.
            // e.printStackTrace();
            isRunning = false;
            Demo0_Util.closeAll(dos, br);    ////初始化时出现异常，就将所有流都关了
        }
    }

    //获取控制台输入的信息
    public String getData() {
        try {
            return br.readLine();
        } catch (IOException e) {
//            e.printStackTrace();
        }
        return "";       //上面的异常不传出去
    }

    // 先从控制台接收数据
    // 再发送数据
    public void send(String msg) {
        //不能输入空的，且还没有异常
        if (msg != null && msg != "") {
            try {
                dos.writeUTF(msg);
                dos.flush();    //差点忘了flush
            } catch (IOException e) {
//                e.printStackTrace();
                Demo0_Util.closeAll(dos, br);    //如果发不出去就直接断开流。

            }
        }

    }

    //线程要做的
    @Override
    public void run() {
        while (isRunning) {
            //System.out.println("q:"+getData());
            send(getData());        //只有在run()方法下才会调用这个receive（一开始想不明白为什么这明明是个方法允许传值）

        }
    }
}

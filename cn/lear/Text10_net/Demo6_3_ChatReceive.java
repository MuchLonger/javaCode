package cn.lear.Text10_net;

import java.io.*;
import java.net.Socket;

/**
 * @description:    信息接收类（线程）
 * 每个线程只要在线，都会一直读取流的信息
 * @Time: 2018/8/17 19:00
 */
public class Demo6_3_ChatReceive implements Runnable {
    //输入流
    private DataInputStream dis;
    private boolean isRunning = true;   //有线程就加的标识

    public Demo6_3_ChatReceive() {
    }

    public Demo6_3_ChatReceive(Socket socket) {
        try {
            dis = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {

            isRunning = false;
            Demo0_Util.closeAll(dis);
        }
    }




//接收数据
    public String receive() {

        String msg = null;
        try {
            msg = dis.readUTF();        //获取信息
        } catch (IOException e) {
//            e.printStackTrace();
            isRunning=false;
            Demo0_Util.closeAll(dis);

        }
        return msg;

    }


    @Override
    public synchronized void run() {
        while (isRunning) {
            System.out.println(receive());      //显示出来
        }
    }
}

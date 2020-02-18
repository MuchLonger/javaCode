package cn.lear.Text10_net;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 * @description: 模拟聊天室练习，，服务端:同样既写出又读取，得出结论：任何信息都得经过服务器，别想着System.out就行了
 * 两步：接收客户端的信息，发送客户端的信息到别的客户端
 * 重点就在流的传递，因为是一直while循环着获取outputStream的值的，所以只要将值放入流内，客户端就会自动获取到信息并传输出来
 * @Time: 2018/8/17 18:25
 */
public class Demo6_1_TCPChatS {
    // 用来存储客户端的容器
    private List<MyChannel> all = new ArrayList<>();


    public static void main(String[] args) throws IOException {
       /* 以前的代码

        //创建服务器
        ServerSocket server = new ServerSocket(9029);
        //接收一个客户端请求
        Socket socket = server.accept();
        //读取数据 --> 输入流
        DataInputStream dis = new DataInputStream(socket.getInputStream());

        //写出数据  --> 输出流
        DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
        */

        //调用下面的start方法
        new Demo6_1_TCPChatS().start();

    }

    //因为main为静态方法 调用不了Mychannel
    public void start() throws IOException {
        ServerSocket server = new ServerSocket(9029);
        //时刻获取对应的流
        while (true) {
            //accept获取的就是Socket对象，内有对应的流
            Socket client = server.accept();
            //将服务器的 Socket 放进去。用来保证流一致
            MyChannel mc = new MyChannel(client);
            //将客户端放进去
            all.add(mc);
            //实现多个客户端，new Thread(一个继承了Runnable的对象).start就是启动多线程的方法
            new Thread(mc).start();
        }
    }

    //服务器只需要实现 先读取再转发 就行了
    //创建一个内部类，方便引用外部类的属性
    //能实现 “一个客户端，一条道路”
    class MyChannel implements Runnable {
        //输入流
        private DataInputStream dis;
        //输出流
        private DataOutputStream dos;
        //标识
        private boolean isRunning = true;
        //名称
        private String name;

        public MyChannel(Socket socket) {
            try {
                //将当前服务器端的socket对应的流放入“信道”中
                this.dis = new DataInputStream(socket.getInputStream());
                this.dos = new DataOutputStream(socket.getOutputStream());

                //获取到客户端传进来的name
                this.name = dis.readUTF();
                //传给新进来的客户端
                this.send("你是 " + name + " 欢迎进来聊天室");
                //传给其他的客户端，只传一次
                this.sendToOthers("\"" + name + "\"" + "进来了", true);

            } catch (IOException e) {
                // e.printStackTrace();
                isRunning = false;
                // Demo0_Util.closeAll(dos);

                sendToOthers(this.name + "离开了聊天室", true);
                all.remove(this);   //当有异常时 将自己从容器中移出
                //Demo0_Util.closeAll(dis, dos);
            }
        }

        //读取其他线程写入的数据，在run里被调用。
        private String receive() {
            String msg = "";
            try {
                //获取Socket内传入的值（使用input流）
                msg = dis.readUTF();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                Demo0_Util.closeAll(dos);
                sendToOthers(this.name + "离开了聊天室", true);
                all.remove(this);   //当有异常时 将自己从容器中移出
                // Demo0_Util.closeAll(dis);

            }
            return msg;
        }

        //发送给发送信息的本机
        private void send(String msg) {

            if (msg == null || msg.equals("")) {
                return;     //排除异常与无传入
            }
            try {
                dos.writeUTF("服务器 --> " + msg);
                //写入到流
                dos.flush();
            } catch (IOException e) {
                //e.printStackTrace();
                isRunning = false;
                Demo0_Util.closeAll(dos);
                sendToOthers(this.name + "离开了聊天室", true);
                all.remove(this);   //当有异常时 将自己从容器中移出
            }
        }

        //将接受到的内容发送给其他客户端，并新增一个系统消息
        private synchronized void sendToOthers(String msg, boolean sys) {
            //以@开头就是私聊。写在sendToOthers里，而不是send，一是减少遍历次数，二是，内部有使用send最后会形成死循环
            if (msg.startsWith("@") && msg.indexOf(":") > -1) {
                //私发给谁
                String name = msg.substring(1, msg.indexOf(":"));      //从1开始，去除@符号
                //获取私发的内容
                String container = msg.substring(msg.indexOf(":") + 1);   //获取从 ":"+1 开始的字符串    （subString,包括头不包括尾）

                for (MyChannel mc :
                        all) {
                    if (mc.name.equals(name)) {
                        mc.send(this.name + "对你说: " + container);
                    }
                }
            }
            //如果不是私聊，再遍历容器
            else {
                for (MyChannel mc :
                        all) {
                    //如果是自己，就跳过。
                    if (mc == this) {
                        continue;
                    }
                    if (sys == false) {       //如果不是系统消息才发出
                        if (msg == "" || msg == null) {
                            return;
                        }
                        mc.send(this.name + "对所有人说：" + msg);   //内容发送给其他人
                    } else {  //如果是系统信息;
                        mc.send("系统信息：" + msg);
                    }
                }
            }
        }


        @Override
        public void run() {
            while (isRunning) {
                sendToOthers(receive(), false);    //只有在run()方法下才会调用这个receive（一开始想不明白为什么这明明是个方法允许传值）
            }
        }
    }
}



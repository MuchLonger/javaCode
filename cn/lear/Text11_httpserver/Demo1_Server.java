package cn.lear.Text11_httpserver;


import java.io.IOException;
import java.net.ServerSocket;

/**
 * @description: 创建服务器并启动
 * @Time: 2018/8/18 16:13
 */
public class Demo1_Server {
    private ServerSocket server;
    //回车换行符
    public static final String CRLF = "\r\n";
    //空格符
    public static final String BLANK = " ";
    //控制循环的开始
    private boolean isShutdown = false;

    public static void main(String[] args) throws IOException {
        Demo1_Server server = new Demo1_Server();
        server.start();

    }

    //服务器开启
    public void start() throws IOException {
        start(9027);
    }

    //自定义端口，启动TCP流。
    public void start(int port) {
        try {
            server = new ServerSocket(port);
        } catch (IOException e) {
            stop();     //如果启动失败则为false
        }

        this.receive(); //自动接收

    }

    //停止
    public void stop() {
        isShutdown = true;
        try {
            server.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    //接收客户端的信息
    private void receive() {

        //开启客户端的多线程
        try {
            while (!isShutdown) {
                new Thread(new Demo5_Dispatcher(server.accept())).start();
            }
        } catch (IOException e) {
            stop();     //出现异常则关闭
        }


        /* 用来显示请求的内容

        //获取到请求
        byte[] data = new byte[8096];
        String msg = null;        //接收客户端的请求信息；
        int len = socket.getInputStream().read(data);         //这是简写的形式，正确的形式是一个一个字节来读（像以前一样）现在是练习，就不用了

        String requestInfo = new String(data, 0, len).trim();   //trim去除空格;
        System.out.println(requestInfo);

        */
        /*
        这是刚刚开始写，因为readLine的缺陷所以换另外一种方法
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        StringBuilder sb = new StringBuilder();   //真正存储的数组

        //msg获取到了信息
        while ((msg = br.readLine()).length() > 0) {
            sb.append(msg);     //添加进数组
            sb.append("\r\n");
            if (msg == null) {        //如果msg没有信息了
                break;
            }
        }
        */
    }


}

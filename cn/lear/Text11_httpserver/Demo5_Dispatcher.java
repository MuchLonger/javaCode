package cn.lear.Text11_httpserver;

import java.io.IOException;
import java.net.Socket;

/**
 * @description: 实现多线程，一个请求与响应就会有一个dispatcher对象
 * @Time: 2018/8/19 14:25
 */
public class Demo5_Dispatcher implements Runnable {
    private Socket socket;
    private Demo3_Request req;    //request，用来获取相对路径的
    private Demo2_Response res;    //response


    private int code=200;

    //初始化构造器
    public Demo5_Dispatcher(Socket socket) {
        this.socket = socket;
        //如果要分析源码的话，建议从response开始看起，因为那里写入了outputStream，而request内读入的是inputStream流内的信息，
        this.req = new Demo3_Request(socket);
        this.res = new Demo2_Response(socket);
    }

    @Override
    public void run() {
        //通过url，然后再通过map搜寻，再通过xml读取，最后使用反射-->返回一个对应的Servlet实例（如LoginServlet类），
        Demo4_Servlet serv=Demo7_WebApp.getServlet(req.getUrl());     //用于写入HTML格式
        if(serv==null){     //如果找不到你这个资源（就是包内找不到对应的java文件）
            this.code=404;       //  找不到对应的处理
        }else {     //加入else
            try {
                //优先将Servlet类内的jsp代码传入res流内，方便服务器在写入信息的时候读取到用户设置的数据
                serv.service(req, res);  //传入Servlet,现在的Servlet内调用了doGet与doPost函数。
            } catch (Exception e) {
                this.code = 500;      //服务器异常
            }
        }
        //传出到客户端
        res.pushToClient(code);


        //关闭
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

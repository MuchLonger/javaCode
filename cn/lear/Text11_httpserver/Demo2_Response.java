package cn.lear.Text11_httpserver;

import cn.lear.Text8_IO.Demo10_autoclose;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Date;

/**
 * @description: 用于封装相应信息
 * @Time: 2018/8/18 17:34
 */
public class Demo2_Response {
    //封装头信息
    private StringBuilder headInfo;
    //回车换行符
    public static final String CRLF = "\r\n";
    //空格符
    public static final String BLANK = " ";
    //存储正文长度（单位：字节）
    private int len = 0;

    //构建传送出客户端的流，这输出流是流向浏览器的
    private BufferedWriter bw;

    //正文的信息
    private  StringBuilder content;


    public Demo2_Response() {
        headInfo = new StringBuilder();
        content=new StringBuilder();
    }

    //一开始的初始化
    public Demo2_Response(Socket socket) {
        this();
        try {
            //写入socket的流信息内，可通过inputStream获取到值
            this.bw=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
        } catch (IOException e) {
            //如果出错了就将它变成空，就不能添加东西了
            headInfo=null;
        }
    }

    //加入正文信息。
    public Demo2_Response print(StringBuilder info){
        content.append(info);
        //注意： 长度是字节长度
        len+=info.toString().getBytes().length;        //调用一次就加一次。

        return this;
    }

    //构建正文 加回车。
    public Demo2_Response println(StringBuilder info){
        content.append(info).append(CRLF);
        //注意： 长度是字节长度
        len+=(info+CRLF).toString().getBytes().length;        //调用一次就加一次。

        return this;
    }


    //相应头
    private void createHeadInfo(int Code) {      //传入应答码         即开头这句话 headInfo.append("HTTP/1.1").append(BLANK).append(Code).append("OK").append(CRLF);

        // *1) HTTP协议版本、状态 代码、描述
        headInfo.append("HTTP/1.1").append(BLANK).append(Code).append(BLANK);
        switch (Code) {
            case 200:
                headInfo.append("OK");
                break;
            case 404:
                headInfo.append("Not Found");
                break;
            case 505:
                headInfo.append("Server Error");
                break;
        }
        headInfo.append(CRLF);      //还是第一行的代码
        // *2) 响应头（Response Head）
        headInfo.append("Server:cqy Server/0.0.1").append(CRLF);
        // 日期
        headInfo.append("Date:").append(new Date()).append(CRLF);
        // *编码
        headInfo.append("Content-type:text/html;charset=UTF-8").append(CRLF);
        // *长度  注意要的是字节长度。
        headInfo.append("Content-Length:").append(len).append(CRLF);

        //正文前的一行
        headInfo.append(CRLF);
    }

    //推送到客户端（在Demo5内使用）并不是在这个类内使用
    public void pushToClient(int code){
        if(headInfo==null){
            code=500;   //服务器出错
        }
        createHeadInfo(code);
        try {
            //先传入headInfo头信息，headInfo通过createHeadInfo（）已经构建好了浏览器的头信息（只是头信息）
            bw.append(headInfo.toString());        //注意，用toString()。

            //再加上正文（就是常用的jsp开头那些<html><meta>等，人工拼接）
            bw.append(content.toString());

            bw.flush();
            //关闭流
            Demo10_autoclose.closeAll(bw);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}

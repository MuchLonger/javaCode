package cn.lear.Text8_IOzifuliu;

import java.io.*;

/**
 * @description: 字节数组 节点流
 * @Time: 2018/8/15 10:36
 */
public class Demo6_ByteArray {

    public static void main(String[] args) throws IOException {
        read(write());
    }

    /*  数组输入流 */
    public static void read(byte[] src) throws IOException {
        //数据源
        /*String msg="数组输入流";
        byte[] src=msg.getBytes();      //getBytes() 是Java编程语言中将一个字符串转化为一个字节数组byte[]的方法*/

        //传入的数据源


        //选择流
        InputStream is =new BufferedInputStream(
                new ByteArrayInputStream(
                        src
                )
        );
        //操作
        byte[] flush=new byte[1024];
        int len=0;
        while((len=is.read(flush))!=-1){
            System.out.println(new String(flush,0,len));
        }
        is.close();
    }

    /*  输出流  与以往的不同 */
    public static byte[] write() throws IOException {
        //选择目的地
        byte[] dest;
        //选择流,不添加对象
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        //操作写出
        String msg="数组输入流";
        byte[] info=msg.getBytes();
        bos.write(info,0,info.length);
        //获取数据
        dest=bos.toByteArray();
        //释放资源
        bos.close();

        return dest;

    }

}

package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description:    处理流，输入流DataInputStream , 输出流DataOutputStream
 * @Time: 2018/8/15 11:57
 */
public class Demo7_data {

    public static void main(String[] args) throws IOException {
    write("D:\\_java\\src\\text\\t.txt");
    read("D:\\_java\\src\\text\\t.txt");

    }
    
    public static void read(String destPath) throws IOException {
        File src=new File(destPath);

        DataInputStream dis=new DataInputStream(
                new BufferedInputStream(
                        new FileInputStream(src)
                )
        );

        double num1=dis.readDouble();
        String fw=dis.readUTF();
        long num2=dis.readLong();
        String str=dis.readUTF();

        System.out.println(str);

    }
    
    /*  写入文件  */
    public static void write(String destPath) throws IOException {
        double point=2.5;
        String fa="创挖";
        long num=100L;
        String str="数据类型";

        //创建流
        File dest=new File(destPath);
        //选择流，不能使用多态
        DataOutputStream dos=new DataOutputStream(      //处理流包裹缓冲再包裹节点流
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );
        //操作, 顺序不能乱
        dos.writeDouble(point);
        dos.writeUTF(fa);
        dos.writeLong(num);
        dos.writeUTF(str);

        dos.flush();

        dos.close();


    }
}

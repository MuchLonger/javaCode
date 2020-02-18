package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: 输入输出流，将字节转到字节数组中
 * @Time: 2018/8/15 12:17
 */
public class Demo8_dataArr {


    public static void main(String[] args) throws IOException {
        byte[] data = write();
        System.out.println(data.length);
        read(data);
    }

    public static void read(byte[] src) throws IOException {


        DataInputStream dis = new DataInputStream(
                new BufferedInputStream(
                        new ByteArrayInputStream(src)
                )
        );
        //得按顺序才能显示
        double num1 = dis.readDouble();
        String fw = dis.readUTF();
        long num2 = dis.readLong();
        String str = dis.readUTF();

        System.out.println(num2);

    }

    /*  写入文件  */
    public static byte[] write() throws IOException {
        double point = 2.5;
        String fa = "创挖";
        long num = 100L;
        String str = "数据类型";

        ByteArrayOutputStream bos = new ByteArrayOutputStream();        //新建数组节点流，

        //选择流，不能使用多态
        DataOutputStream dos = new DataOutputStream(      //处理流包裹缓冲再包裹节点流
                new BufferedOutputStream(
                        bos     //添加数组节点，也可改成具体文件，这样就能保存在文件中
                )
        );
        //操作, 顺序不能乱
        dos.writeDouble(point);
        dos.writeUTF(fa);
        dos.writeLong(num);
        dos.writeUTF(str);
        dos.flush();

        byte[] bytes = bos.toByteArray();



        dos.close();

        return bytes;
    }
}

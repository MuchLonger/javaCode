package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: IO流之复制
 * @Time: 2018/8/13 23:27
 */
public class Demo5_copy {
    public static void IOInput(File src, File dest) throws IOException {
        //选择流
        InputStream is = new FileInputStream(src);
        OutputStream os = new FileOutputStream(dest);
        if (dest.isDirectory()) {
            System.out.println("不能建立于文件同名的文件");
            throw new IOException("不能建立于文件同名的文件");
        }

        //文件复制，循环的读取和写出
        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = is.read(flush)) != -1) {
            //写出
            os.write(flush, 0, len);
        }

        //强制刷出
        os.flush();
        //关闭流，先打开的后关闭
        os.close();
        is.close();


    }

    public static void main(String[] args) throws IOException {

    }
}

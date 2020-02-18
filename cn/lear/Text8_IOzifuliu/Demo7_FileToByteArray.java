package cn.lear.Text8_IOzifuliu;

import java.io.*;

/**
 * @description: 文件转到字节数组(文件输入流)， 字节数组再转到文件(文件输出流)    （复制）
 * @Time: 2018/8/15 11:00
 */
public class Demo7_FileToByteArray {

    public static void main(String[] args) throws IOException {
        byte[] data = getBytesFromFile("D:/_java/src/text/1.jpg");
        writeArrayToFile(data, "D:/_java/src/text/112.jpg");
    }

    public static byte[] getBytesFromFile(String srcPath) throws IOException {
        //创建文件源
        File src = new File(srcPath);
        //创建目的地数组
        byte[] dest = null;
        //选择流，注意不能使用多态
        InputStream is = new BufferedInputStream(
                new FileInputStream(
                        src
                )
        );
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      //这句话用于调用写入数组的函数

        //操作， 不断的读取文件
        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = is.read(flush)) != -1) {
            //写出
            System.out.println(new String(flush));
            bos.write(flush, 0, len);     //将flush存到bos缓冲流里面
            System.out.println(bos);
        }

        bos.flush();

        dest = bos.toByteArray();

        bos.close();
        is.close();
        return dest;
    }

    public static void writeArrayToFile(byte[] src, String dest) throws IOException {
        //创建源，目的地
        File des = new File(dest);
        //选择流
        InputStream is = new BufferedInputStream(new ByteArrayInputStream(src));      //将src存储到is缓存区内
        //文件输出流
        OutputStream os = new BufferedOutputStream(new FileOutputStream(des));

        byte[] flush = new byte[1024];
        int len = 0;

        while ((len = is.read(flush)) != -1) {
            os.write(flush, 0, len);
        }
        os.flush();

        os.close();
        is.close();
    }

}

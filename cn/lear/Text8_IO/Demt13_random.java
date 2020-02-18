package cn.lear.Text8_IO;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @description: RandomAccessFile的seek练习，从seek里面的第n个开始读取
 * @Time: 2018/8/15 17:05
 */
public class Demt13_random {

    public static void main(String[] args) throws IOException {
        RandomAccessFile rnd = new RandomAccessFile(new File("D:/_java/src/text/print.txt"), "r");

        rnd.seek(10);       //从第10个开始读取，且是从0开始数起的
        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = rnd.read(flush)) != -1) {
            String msg;
            if (len > 25) {       //限制在200个
                msg = new String(flush, 0, 25);
            } else {
                msg = new String(flush, 0, len);

            }
            System.out.println(msg);
        }
        Demo10_autoclose.closeAll(rnd);

    }

}

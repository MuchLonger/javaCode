package cn.lear.Text8_IO;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description:
 * @Time: 2018/8/15 15:32
 */

//使用方法 close(os,is)即可
public class Demo10_autoclose {
    public static void close(Closeable... clo) {        //...代表可变（个数)参数，但必须是相同类型的，且放在形参的最后一位，处理的方式同数组一致
        for (Closeable temp :
                clo) {
            if (temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    /*   使用泛型方法  */
    public static <T extends Closeable> void closeAll(T... t) {

        for (T temp :
                t) {
            if (temp != null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
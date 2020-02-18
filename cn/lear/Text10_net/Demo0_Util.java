package cn.lear.Text10_net;

import java.io.Closeable;
import java.io.IOException;

/**
 * @description:    本Text所要用到的工具。
 * @Time: 2018/8/17 19:18
 */
public class Demo0_Util {
    public static void closeAll(Closeable ... io){
        for (Closeable temp :
                io) {
            if(temp!=null) {
                try {
                    temp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}

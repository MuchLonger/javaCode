package cn.lear.Text8_IO;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @description: 自己封装一个输入功能
 * @Time: 2018/8/15 16:17
 */
public class Demt11_3_redirectIn {

    public static void main(String[] args) throws IOException {
        InputStream is = System.in;

        BufferedReader br = new BufferedReader(new InputStreamReader(is));  //用来使用readLine方法。

        System.out.println("请输入");

        String msg = br.readLine();     //br也包含着输入流
        System.out.println(msg);


    }

}

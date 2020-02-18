package cn.lear.Text8_IO;

import java.io.*;
import java.util.Scanner;

/**
 * @description: System.in ,  System.out ,  System.err 练习
 * @Time: 2018/8/15 15:54
 */
public class Demt11_1_printStream {

    public static void main(String[] args) throws FileNotFoundException {
        InputStream is=System.in;
        File src=new File("D:/_java/src/text/pruin.txt");

        /*  让其指向了src的文本的内容 */
        is=new BufferedInputStream(
                new FileInputStream(src)
        );

        Scanner sc=new Scanner(is);

        System.out.println("请输入: ");

        //输出的是src里面的内容
       System.out.println(sc.next());

    }

}



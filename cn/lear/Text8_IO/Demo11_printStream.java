package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description:    打印流练习 --> 属于处理流
 * @Time: 2018/8/15 15:47
 */
public class Demo11_printStream {


    public static void main(String[] args) throws FileNotFoundException {
        System.out.println("test");

        PrintStream ps=System.out;

        ps.println(false);

        File src=new File("D:/_java/src/text/pruin.txt");

        ps=new PrintStream(
                new BufferedOutputStream(
                        new FileOutputStream(src)
                )
        );
        //快速输入到文件里面
        ps.println("io流");

        ps.close();

    }
}

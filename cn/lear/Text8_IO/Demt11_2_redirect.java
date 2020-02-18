package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: System的重定向
 * setIn(InputStream in)
 * setOut(PrintStream out)
 * setErr(PrintStream err)
 * @Time: 2018/8/15 16:05
 */
public class Demt11_2_redirect {

    public static void main(String[] args) throws FileNotFoundException {
        //将System.out重定向到指定文件，
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(new File("D:/_java/src/text/print.txt")
)),true));
        //传入指定的文件内
        System.out.println("ccc");

        //重回控制台
        System.setOut(new PrintStream(new BufferedOutputStream(new FileOutputStream(FileDescriptor.out
        )),true));

        System.out.println("ccc");
    }


}

package cn.lear.Text8_IOzifuliu;

import java.io.*;

/**
 * @description: OutputStreamWrite 编码，InputStreamReader 解码, 字节转字符
 * @Time: 2018/8/15 9:51
 */
public class Demo5_OutInput {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(     //用Buffer包裹
                new InputStreamReader(      //因为Buffer需要的是Reader的对象所以要添加这个,且通过这个函数添加的编码集
                        new FileInputStream(    //通过这个就可以指定解码集,这是字节流的时候所使用的。
                                new File("D:/_java/src/text/a.txt")), "UTF-8"));       //在InputStreamReader里面添加编码集

        String info = null;
        while ((info = br.readLine()) != null) {
            System.out.println(info);
        }
        BufferedWriter wr = new BufferedWriter(
                new OutputStreamWriter(
                        new FileOutputStream(
                                new File("D:/_java/src/text/h.txt")
                        )
                        , "GBK")
        );

        wr.write("陈麒涌真帅");

        wr.flush();

        BufferedReader bk = new BufferedReader(     //用Buffer包裹
                new InputStreamReader(      //因为Buffer需要的是Reader的对象所以要添加这个,通过这个函数添加的编码集
                        new FileInputStream(    //通过这个就可以指定解码集,这是字节流的时候所使用的。
                                new File("D:/_java/src/text/h.txt")), "GBK"));       //在InputStreamReader里面添加编码集

        String info1 = null;
        while ((info1 = bk.readLine()) != null) {
            System.out.println(info1);
        }
    }


}

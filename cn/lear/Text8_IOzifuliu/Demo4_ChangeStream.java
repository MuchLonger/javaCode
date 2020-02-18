package cn.lear.Text8_IOzifuliu;

import java.io.UnsupportedEncodingException;

/**
 * @description: 转换流的练习（编码与解码）
 * @Time: 2018/8/14 16:19
 */
public class Demo4_ChangeStream {

    public static void main(String[] args) throws UnsupportedEncodingException {
        String str="中国";        //解码，byte -> char
        byte[] data=str.getBytes();     //编码  char -> byte
        System.out.println(new String(data));   //当编码与解码一致时，才显示正常
        data=str.getBytes("GBK");
        System.out.println(new String(data));

        byte[] data2="中国".getBytes("GBK");      //编码 byte -> char
        str=new String(data2,"GBK");        //解码        char -> byte
        System.out.println(str);


    }

}

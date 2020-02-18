package cn.lear.Text15_ClassLoader;

import java.io.*;

/**
 * @description: 加密的操作
 * @Time: 2018/8/23 11:51
 */
public class Demo4_encryption {

    public static void encrypt(String src, String dest) {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(src);      //读取
            fos = new FileOutputStream(dest);        //写入

            int aByte=-1;       //一个字节
            while((aByte=fis.read())!=-1){      //一次读一个字节
                fos.write(aByte^0xff);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null) {
                    fis.close();        //关闭
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //加密
        encrypt("D:\\_java\\src\\src\\my.class","D:\\_java\\src\\src\\text\\my.class");

        //解密
        Demo4_2_Deencryption fsc=new Demo4_2_Deencryption("d:/_java/src/src/text");
        Class<?> c=fsc.loadClass("my");     // c输出为 class my

        System.out.println(c);
        System.out.println(c.getClassLoader());
    }
}

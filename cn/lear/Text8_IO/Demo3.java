package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: IO流的输入流练习
 * @Time: 2018/8/13 22:09
 */
public class Demo3 {


    public static void main(String[] args) {
        //先联系起来
        File src = new File("D:/_java/src/text/a.txt");
        //选择流
        InputStream is = null;        //提升作用域（变成更大的局部变量）
        try {
            is = new FileInputStream(src);
            //不断的读取缓冲数组
            byte[] car = new byte[10];
            //接受实际读取的大小
            int len = 0;
            //循环读取
            while ((len = is.read(car)) != -1){     //获取读取数据并且判断
                String info=new String(car,0,len);
                System.out.println(info);

            }

        } catch (FileNotFoundException e) {
            System.out.println("文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取文件异常");
            e.printStackTrace();
        }finally {
            if(null!=is){
                try {
                    is.close();     //最后关闭文件
                } catch (IOException e) {
                    System.out.println("关闭文件失败");
                    e.printStackTrace();
                }
            }
        }

    }

}

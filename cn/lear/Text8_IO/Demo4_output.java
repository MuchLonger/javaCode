package cn.lear.Text8_IO;

import java.io.*;

/**
 * @description: 输出流练习
 * @Time: 2018/8/13 23:00
 */
public class Demo4_output {


    public static void main(String[] args){
        //建立联系
        File src = new File("D:/_java/src/text/a.txt");
        OutputStream os=null;
        try {
            //输出流
            os=new FileOutputStream(src,true);      //true表示从后面添加进去，默认是false替换原有内容
            //操作
            String str="cqyzhenshuai\n";
            //str是字符串数组，需要将字符串数组转成字节数组
            byte[] data=str.getBytes();

            os.write(data,0,data.length);

            os.flush();     //避免没有写出去，将其强制刷新出去（不懂）

        } catch (FileNotFoundException e) {
            System.out.println("文件找不到");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("文件写出失败");
            e.printStackTrace();
        }finally {
            if(os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    System.out.println("文件关闭失败");
                    e.printStackTrace();
                }
            }
        }


    }
}

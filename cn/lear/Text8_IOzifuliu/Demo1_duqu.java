package cn.lear.Text8_IOzifuliu;

import java.io.*;

/**
 * @description:    纯文本读取
 * @Time: 2018/8/14 12:06
 */
public class Demo1_duqu {

    public static void main(String[] args)  {
        File src=new File("D:/_java/src/text/a.txt");

        Reader reader=null;
        try {
            reader=new FileReader(src);
            //读取操作
            char[] flush=new char[1024];
            int len=0;
            while((len=reader.read(flush))!=-1){
                //字符数组转成字符串
                String str=new String(flush,0,len);     //仅允许转len个
                System.out.println(str);
            }

        } catch (FileNotFoundException e) {
            System.out.println("源文件不存在");
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("读取失败");
            e.printStackTrace();
        }finally {
            try {
                if(reader!=null) {
                    reader.close();
                }
            } catch (IOException e) {
                System.out.println("文件关闭失败");
                e.printStackTrace();
            }
        }


    }
}

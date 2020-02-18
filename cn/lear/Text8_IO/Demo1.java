package cn.lear.Text8_IO;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;

/**
 * @description: IO流练习
 * @Time: 2018/8/13 20:52
 */
public class Demo1 {


    public static void main(String[] args) throws IOException {
        File sr = new File("D:/_java/src/text");

        if(sr.isDirectory()){
            String[] arr=sr.list();
            for (String s :
                    arr) {
                System.out.println(s+",");
            }
            System.out.println("----------------------");

            File[] subFile=sr.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return new File(dir,name).isFile()&&name.endsWith(".jpg");  //只有是文件且后缀为，jpg才返回true，允许传入
                }

            });

            for (File temp :
                    subFile) {
                System.out.println(temp.getAbsolutePath());
            }



        }


    }
}

package cn.lear.Text8_IO;

import java.io.File;
import java.util.Arrays;

/**
 * @description: IO流练习2:递归输出文件名称
 * @Time: 2018/8/13 21:53
 */
public class Demo2 {


    public static void main(String[] args){
        File sr = new File("D:/_java/src/text");

        printName(sr);
        System.out.println("_---------");
        File[] roots=File.listRoots();
        System.out.println(Arrays.toString(roots));

    }

    public static void printName(File src){     //递归函数
        if(src==null|| !src.exists()){
            return;
        }
        System.out.println(src.getAbsolutePath());

        if(src.isDirectory()){
            for (File sub :
                    src.listFiles()) {
                printName(sub);     //一直遍历下去
            }
        }
        
    }

}

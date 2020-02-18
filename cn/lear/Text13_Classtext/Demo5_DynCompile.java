package cn.lear.Text13_Classtext;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @description: 测试动态编译效果
 * @Time: 2018/8/21 23:42
 */
public class Demo5_DynCompile {

    public static void main(String[] args) throws IOException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        /*    以下是动态生成代码文件   */
        String path = "D:\\\\_java\\\\src\\\\src\\\\my.java";
        String str = "public class my{public static void main(String[] args){System.out.println(\"cqy,HelloWorld!\");}}";

        OutputStream os = new BufferedOutputStream(new FileOutputStream(new File(path)));       //写入到文件
        byte[] flush = str.getBytes();
        os.write(flush);
        os.flush();

        InputStream is = new BufferedInputStream(new FileInputStream(new File(path)));      //读出文件
        byte[] b=new byte[1024];
        is.read(b);

        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();    //获得编译对象

        int result = compiler.run(is, os, null, "D:\\_java\\src\\src\\my.java"); //返回是否成功,传入is，os
        System.out.println(result == 0 ? "编译成功" : "编译失败");
        /*   记得关闭   */
        os.close();
        is.close();


        /*  以下是静态的编译(用反射实现)。 同时不能执行动态生成的java文件，但可以执行两次现在这个main方法（第一次创建文件，第二次文件存在了，就可以执行了）  */
        System.out.println("--------------------------------------");
        URL[] urls=new URL[]{new URL("file:/"+"D:/_java/src/src")};        //.net类里面的，通过网站获取的URL

        URLClassLoader loader=new URLClassLoader(urls);     //后面会讲

        Class c=loader.loadClass("my");
        Method m=c.getMethod("main",String[].class);        //获取main方法
        m.invoke(null,(Object)new String[]{});      //因为main是静态方法，所以参数1（代表的是对象）为null，同时需要强转为Object,


       /*  以下是静态的运行（用Runtime实现）。

       System.out.println("--------------------------------------");

        Runtime run=Runtime.getRuntime();
        Process process=run.exec("java -cp D:/_java/src/src myJava");       //编译的位置，且只能编译已经有的java文件，无法编译动态生成的文件，注意语法

        InputStream in=process.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(in));    //获取到了process的输入流

        String info="";
        while((info=reader.readLine())!=null){      //读取
            System.out.println(info);
        }

        */

    }

}

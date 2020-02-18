package cn.lear.Text15_ClassLoader;

import cn.lear.Text8_IO.Demo10_autoclose;

import java.io.*;

/**
 * @description: 自定义文件系统加载器（自定义类加载器），作用：传入一个path，然后加载.class文件
 * @Time: 2018/8/22 23:29
 */
public class Demo2_FileSystemClass extends ClassLoader {        //第一步 继承Classloader
    //根目录
    private String rootDir;

    //初始化根目录
    public Demo2_FileSystemClass(String rootDir) {
        this.rootDir = rootDir;
    }

    //重写父类方法
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        Class<?> c = findLoadedClass(name);      //查找已加载的类，看看是否已被加载
        //如果已经加载过，直接返回加载过的类
        if (c != null) {
            return c;
        } else {       //如果没有加载过
            ClassLoader parent = this.getParent();        //获得父级类加载器
            try {
                c = parent.loadClass(name);       //让父亲去加载
            } catch (ClassNotFoundException e) {
            }

            if (c != null) {        //同上
                return c;
            } else {

                byte[] classData = getClassData(name);    //getClassData是自己写的方法，作用是通过将一个类传进去，然后返回一个字节数组
                if (classData == null) {
                    throw new ClassNotFoundException("Class没有被响应");     //如果还是不能读取。则手动抛出异常
                } else {
                    String[] arr=name.split("\\.");
                    c = defineClass(arr[arr.length-1], classData, 0, classData.length);       //类名，字节数组，偏移量，长度
                    return c;
                }
            }
        }
    }

    /*         通过将一个类传进来，然后返回一个字节数组                 */
    private byte[] getClassData(String classname) {
        String path = rootDir + "/" + classname.replace(".", "/") + ".class";        //构成一个.class文件的完整路径

        InputStream is = null;       //获取输入流
        ByteArrayOutputStream bos = new ByteArrayOutputStream();      //获取文档输出流，写入到byte数组内
        byte[] flush = new byte[1024];
        int len = 0;
        try {
            is = new FileInputStream(path);


            while ((len = is.read(flush)) != -1) {
                bos.write(flush, 0, len);        //写入到数组内
            }

            return bos.toByteArray();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;         //记得返回null
        } catch (IOException e) {
            e.printStackTrace();
            return null;        //记得返回null
        }finally {
            Demo10_autoclose.closeAll(is, bos); //关闭
        }
    }


}

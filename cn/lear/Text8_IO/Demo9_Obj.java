package cn.lear.Text8_IO;

import java.io.*;
import java.util.Arrays;

/**
 * @description:  ObjectOutputStream序列化练习
 * @Time: 2018/8/15 14:56
 */
public class Demo9_Obj {

    public static void main(String[] args){
        try {
            seri("D:/_java/src/text/k.txt");
            read("D:/_java/src/text/k.txt");
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    //反序列化，从文本中读取对象
    public static void read(String destPath) throws IOException, ClassNotFoundException {
        File src=new File(destPath);

        ObjectInputStream ois=new ObjectInputStream(
                new BufferedInputStream(
                        new FileInputStream(
                                src
                        )
                )
        );
        //当是Employee类时 强转为Emploee类型
        Object obj=ois.readObject();
        if(obj instanceof Employee) {
            Employee emp=(Employee)obj;
            System.out.println(emp.getName());      //添加了transient，结果为null
            System.out.println(emp.getSalary());        //正常显示
        }
        obj=ois.readObject();
        int[] arr=(int[])obj;
        System.out.println(Arrays.toString(arr));
        Demo10_autoclose.closeAll(ois);


    }
    
    
    //序列化，用来将对象存进文本里面
    public static void seri(String destPath) throws IOException {
        Employee emp=new Employee("cqy",20000);
        int[] arr={1,2,3,4,5};
        File dest=new File(destPath);
        ObjectOutputStream dos=new ObjectOutputStream(
                new BufferedOutputStream(
                        new FileOutputStream(dest)
                )
        );

        dos.writeObject(emp);
        dos.writeObject(arr);

        dos.flush();

        dos.close();



    }

}


class Employee implements java.io.Serializable{     //想要序列化必须实现这个接口（虽然里面什么都没有）
    private transient String name;      //如果不想被序列化的加上transient关键词
    private double salary;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Employee() {
    }

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
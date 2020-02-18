package cn.lear.Text16_GOF;

/**
 * @description:    备忘录模式练习：用来保存Emp原来的值
 * @Time: 2018/8/26 14:28
 */
public class Demo8_1_EmpMemento {
    private String ename;
    private int age;
    private double salary;

    //构造器传入的是Emp对象
    public Demo8_1_EmpMemento(Demo8_1_Emp emp) {
        this.ename = emp.getEname();
        this.age = emp.getAge();
        this.salary = emp.getSalary();
    }


    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

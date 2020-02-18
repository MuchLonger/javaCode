package cn.lear.Text16_GOF;

/**
 * @description: 备忘录模式练习： 备忘录
 * @Time: 2018/8/26 14:30
 */
public class Demo8_1_Emp {
    private String ename;
    private int age;
    private double salary;

    //备忘，将当前的值传入到EmpMemento类内保存起来
    public Demo8_1_EmpMemento memento() {
        return new Demo8_1_EmpMemento(this);
    }

    //进行数据恢复，根据传入的备忘录对象来恢复
    public void recovery(Demo8_1_EmpMemento mmt) {
        this.age = mmt.getAge();
        this.ename = mmt.getEname();
        this.salary = mmt.getSalary();
    }



    public Demo8_1_Emp(String ename, int age, double salary) {
        this.ename = ename;
        this.age = age;
        this.salary = salary;
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

    public String getEname() {
        return ename;
    }

}

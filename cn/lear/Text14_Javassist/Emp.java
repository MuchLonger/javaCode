package cn.lear.Text14_Javassist;

/**
 * @description:    测试生成类
 * @Time: 2018/8/22 11:43
 */
@cqq(name="cqy",year = 2018)
public class Emp {
    private int empNp;
    private String ename;

    public int getEmpNp() {
        return empNp;
    }

    public void Hey(int b){

        System.out.println("第一句");
        System.out.println("Cqy!helloWorld,"+b);
        System.out.print("，第三句，");

    }

    public Emp(int empNp, String ename) {
        this.empNp = empNp;
        this.ename = ename;
    }

    public Emp() {
    }

    public void setEmpNp(int empNp) {
        this.empNp = empNp;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }
}


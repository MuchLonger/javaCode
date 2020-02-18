package cn.lear.Text20_ORM;

import java.util.Date;

/**
 * @description:    利用JavaBean雇员类对象保存数据库的值
 * @Time: 2018/8/28 21:12
 */
public class Emp {
    //最好使用包装类
    private Integer id;
    private String empName;
    private Integer age;
    private Double salary;
    private Date birthday;
    private Integer deptId;
    //空构造器（必要）
    public Emp() {
    }

    public Emp(String empName, Integer age, Double salary) {
        this.empName = empName;
        this.age = age;
        this.salary = salary;
    }



    public Emp(Integer id, String empName, Integer age, Double salary, Date birthday, Integer deptId) {
        this.id = id;
        this.empName = empName;
        this.age = age;
        this.salary = salary;
        this.birthday = birthday;
        this.deptId = deptId;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getDeptId() {
        return deptId;
    }

    public void setDeptId(Integer deptId) {
        this.deptId = deptId;
    }
}

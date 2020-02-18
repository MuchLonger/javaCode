package cn.lear.text;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 雇员类
 * @Time: 2018/8/11 15:20
 */
public class Employee {
    private int ID;

    public Employee() {
    }

    public Employee(int ID, String name, int salary, String department, String hireDate) {
        this.ID = ID;
        this.name = name;
        this.salary = salary;
        this.department = department;

        DateFormat d=new SimpleDateFormat("yyyy-MM");
        try {
            this.hireDate=d.parse(hireDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private  String name;
    private int salary;
    private String department;
    private Date hireDate;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }
}

package cn.lear.Text4;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:    利用整一个对象将学生类集合起来
 * @Time: 2018/8/12 10:57
 */
public class ClassRoom {
    private String no;
    private List<Student> stuList;
    private double total;

    public ClassRoom() {
        stuList=new ArrayList<>();
    }

    public ClassRoom(String no) {
        this();
        this.no=no;
    }

    public List<Student> getStuList() {
        return stuList;
    }

    public void setStuList(List<Student> stuList) {
        this.stuList = stuList;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public ClassRoom(String no, List<Student> stuList, double total) {
        this.no = no;
        this.stuList = stuList;
        this.total = total;
    }
}

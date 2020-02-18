package cn.lear.Text16_GOF;

import java.util.Date;

/**
 * @description: 测试深复制
 * @Time: 2018/8/24 16:43
 */
public class Demo2_1_DeepClone implements Cloneable {

    private String sname;
    private Date birthday;
/*
//                浅复制
    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("浅复制");
        return super.clone();
    }*/

    /*            深复制              */

    @Override
    protected Object clone() throws CloneNotSupportedException {
        System.out.println("深复制");
        Demo2_1_DeepClone obj = (Demo2_1_DeepClone) super.clone();//obj就是一个新生的对象
        /*            将原来的属性一一克隆              */
        obj.birthday = (Date) this.birthday.clone();//这是将复制在新生的对象上
        return obj;
    }

    public Demo2_1_DeepClone() {
    }

    public Demo2_1_DeepClone(String sname, Date birthday) {
        this.sname = sname;
        this.birthday = birthday;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

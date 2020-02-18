package cn.lear.text;

/**
 * @description:    Text13的练习
 * @Time: 2018/8/21 18:25
 */
public class User {
    private int id=1001;
    private int age;
    private String name;

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String Uname;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge()throws Exception {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User() {
    }

    public User(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }
}

class cqy extends User {
    private int age;

    public int getAge()throws Exception{
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
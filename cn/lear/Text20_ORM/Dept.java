package cn.lear.Text20_ORM;

/**
 * @description:    利用JavaBean部门类对象保存数据库内容
 * @Time: 2018/8/28 21:16
 */
public class Dept {
    private Integer id;
    private String dName;
    private String address;
    //空构造器（必要）
    public Dept() {
    }

    public Dept(Integer id, String dName, String address) {
        this.id = id;
        this.dName = dName;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}

package cn.lear.Text12_annotation;

/**
 * @description: Object Relation Mapping ，对象关系映射练习
 * @Time: 2018/8/21 17:11
 */
@ORMAnnotation("tb_student")
public class Demo3_1_ORM {

    @ORMField(columnName = "id", type = "int", length = 10)
    private int id;

    @ORMField(columnName = "sName", type = "varchar", length = 10)
    private String sName;

    @ORMField(columnName = "age", type = "int", length = 3)
    private int age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    @ORMField(columnName = "methodName getAge", type = "return int", length = 100)
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

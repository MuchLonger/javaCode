package cn.lear.Text4;

/**
 * @description: 分拣存储练习
 * @Time: 2018/8/12 10:55
 */
public class Student {
    private String name;
    private String no;
    private double score;

    public Student(String name, String no, double score) {
        this.name = name;
        this.no = no;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public Student() {
    }
}

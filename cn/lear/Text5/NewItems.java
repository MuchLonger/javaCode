package cn.lear.Text5;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description: 业务工具(Collections)练习
 * @Time: 2018/8/12 15:55
 */
public class NewItems implements java.lang.Comparable<NewItems> {   //重写CompareTo
    private String title;       //标题
    private int hits;   //点击量
    private Date pubTime;       //发布时间

    public NewItems() {
    }

    public NewItems(String title, int hits, Date pubTime) {
        this.title = title;
        this.hits = hits;
        this.pubTime = pubTime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getHits() {
        return hits;
    }

    public void setHits(int hits) {
        this.hits = hits;
    }

    public Date getPubTime() {
        return pubTime;
    }

    public void setPubTime(Date pubTime) {
        this.pubTime = pubTime;
    }

    @Override
    public int compareTo(NewItems o) {  //先按发布时间降序，否则按点击量降序，再则按标题
        int result;
        result = -this.pubTime.compareTo(o.getPubTime());  //加个负号变成降序
        if (0 == result) {      //如果时间 相同了
            result = this.hits - o.getHits();
            if (0 == result) {  //点击量也相同的话
                result = -this.title.compareTo(o.getTitle());   //降序
            }
        }
        return result;
    }

    @Override
    public String toString() {      //重写toString
        StringBuilder sb = new StringBuilder();
            //以下是链式存储
//        sb.append("标题: ").append(this.title).append(",时间").append(new SimpleDateFormat("yyyy-MM-dd-ss").format(this.pubTime)).append(",点击量").append(this.hits+"\n");
        sb.append("标题: ").append(this.title);           //设置标题格式
        sb.append(",时间").append(new SimpleDateFormat("yyyy-MM-dd-hh-mm-ss").format(this.pubTime));        //设置时间格式，注意new SimpleDateformat后的括号
        sb.append(",点击量").append(this.hits + "\n");         //设置点击量格式

        return sb.toString();
    }
}

package cn.lear.Text19_JDBC;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @description:    时间的测试
 * @Time: 2018/8/28 10:46
 */
public class Demo6_Time {
    //字符串代表的日期转为long类型的方法（因为java.sql.Date需要的是long类型的数）
    public static long strDate(String dateStr){
        //获得格式，年月日时分秒
        DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        try {
            //转成字符串之后再使用getTime（）获取long类型的值
            return format.parse(dateStr).getTime();
        } catch (ParseException e) {
            e.printStackTrace();
            return 0;
        }

    }

    public static void main(String[] args){
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc", "root", "123456");

            //取时间区间
            ps=conn.prepareStatement("select * from t_user where regTime>? and regTime <?");

            java.sql.Date start=new java.sql.Date(strDate("2018-8-27 11:00:00"));
            java.sql.Date end=new java.sql.Date(strDate("2018-8-30 11:00:00"));

            ps.setObject(1,start);
            ps.setObject(2,end);

            rs=ps.executeQuery();

            while(rs.next()){
                System.out.println(rs.getInt("id")+"---"+rs.getTimestamp(4));
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                try {
                    //记得关闭连接
                    ps.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            if (conn != null) {
                try {
                    //记得关闭连接
                    conn.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

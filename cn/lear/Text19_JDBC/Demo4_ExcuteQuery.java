package cn.lear.Text19_JDBC;

import java.sql.*;

/**
 * @description:    excuteQuery练习，
 * @Time: 2018/8/27 21:17
 */
public class Demo4_ExcuteQuery {

    public static void main(String[] args) {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc", "root", "123456");

            String sql = "select * from t_user where id>?";

            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setInt(1, 2);

            //获得结果集
            ResultSet rs = ps.executeQuery();

            //rs.next指的是boolean 是否还有下一行，（因为返回是一行一行的返回的）
            while (rs.next()) {
                //rs.getObject(2) , 2代表的是列数（返回第二列）
                System.out.println(rs.getInt(1) + "-" + rs.getString(2) + "-" + rs.getString(4));

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
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

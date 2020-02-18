package cn.lear.Text19_JDBC;

import java.sql.*;

/**
 * @description: 批处理练习
 * @Time: 2018/8/27 23:19
 */
public class Demo5_batch {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc", "root", "123456");

            //将JDBC的事务提交设置为手动提交
            conn.setAutoCommit(false);

            //采用Statement的方式，因为PreparedStatement的容量太小，所以得用Statement
            stmt=conn.createStatement();
            long start=System.currentTimeMillis();
            for (int i=0;i<20000;i++){
                stmt.addBatch("insert into t_user(username,pwd,regTime) values ('cqy"+i+"',66666,now())");
            }

            stmt.executeBatch();


            conn.commit();      //手动提交事务

            long end=System.currentTimeMillis();
            System.out.println("总耗时"+(end-start));


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (rs != null) {
                try {
                    //记得关闭连接
                    rs.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (stmt != null) {
                try {
                    //记得关闭连接
                    stmt.close();

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

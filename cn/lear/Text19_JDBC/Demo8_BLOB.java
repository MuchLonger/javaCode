package cn.lear.Text19_JDBC;

import cn.lear.Text8_IO.Demo10_autoclose;

import java.io.*;
import java.sql.*;

/**
 * @description: 二进制大对象的使用
 * @Time: 2018/8/28 12:05
 */
public class Demo8_BLOB {
    public static void main(String[] args) {

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BufferedWriter bw = null;
        InputStream r = null;
        OutputStream os = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc", "root", "123456");

            /*将照片写入数据库内

            ps=conn.prepareStatement("insert into t_user(username,head) values(?,?)");
            ps.setString(1,"yu");
            ps.setBlob(2,new FileInputStream("D:\\_java\\src\\head.jpg"));

            ps.executeUpdate();
            */

            ps = conn.prepareStatement("select * from t_user where id=?");
            ps.setObject(1, 20017);

            rs = ps.executeQuery();

            while (rs.next()) {
                Blob b = rs.getBlob("head");
                //传出的是inputStream属性
                r = b.getBinaryStream();
                os = new FileOutputStream("D:\\_java\\src\\c.jpg");

                int temp = 0;
                while ((temp = r.read()) != -1) {
                    os.write(temp);
                }
                os.flush();

            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Demo10_autoclose.closeAll(r, os);
            if (rs != null) {
                try {
                    //记得关闭连接
                    rs.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
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


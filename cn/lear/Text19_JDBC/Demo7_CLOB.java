package cn.lear.Text19_JDBC;

import java.io.*;
import java.sql.*;

/**
 * @description: 文本大对象操作（clob）
 * @Time: 2018/8/28 11:16
 */
public class Demo7_CLOB {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BufferedWriter bw=null;
        Reader r=null;
        try {
            conn=JDBCUtil.getMysqlConn();


            /* 存入信息

            ps = conn.prepareStatement("insert into t_user(username,info) values (?,?)");

            ps.setString(1, "cyy");
            //直接传入Reader来读取文本的内容
            ps.setClob(2, new FileReader("D:\\_java\\src\\b.txt"));
            */

            //取出信息
            ps = conn.prepareStatement("select * from t_user where id=?");
            ps.setObject(1, 20015);
            rs = ps.executeQuery();
            while (rs.next()) {
                //取出Clob对象
                Clob clob = rs.getClob("info");
                //返回一个字符流
                r = clob.getCharacterStream();
                int temp = 0;
                StringBuilder str = new StringBuilder("");
                while ((temp = r.read()) != -1) {
                    System.out.print((char) temp);
                    str.append((char) temp);
                }
                bw = new BufferedWriter(new FileWriter("D:\\_java\\src\\a.txt"));
                bw.write(str.toString());
                bw.flush();
            }


        }  catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
         JDBCUtil.closeIts(rs,ps,conn);
        }

    }
}

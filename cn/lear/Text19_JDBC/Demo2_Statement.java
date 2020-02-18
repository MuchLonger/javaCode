package cn.lear.Text19_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @description: 练习使用Statement执行SQL语句，(有SQL注入的危险）
 * @Time: 2018/8/27 18:40
 */
public class Demo2_Statement {

    public static void main(String[] args){
        try {
            //加载CLASS文件
            Class.forName("com.mysql.jdbc.Driver");
            //建立连接
            Connection  conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");
            //获得Statement对象(用得少)
            Statement stmt=conn.createStatement();

            String sql="insert into t_user(username,pwd,regTime) values ('yyy',123,now())";
            stmt.execute(sql);



        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

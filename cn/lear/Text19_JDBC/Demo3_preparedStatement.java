package cn.lear.Text19_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * @description:    测试PreparedStatement的基本用法
 * @Time: 2018/8/27 18:53
 */
public class Demo3_preparedStatement {

    public static void main(String[] args){
        try {
            //头两步
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc","root","123456");

            String sql="insert into t_user(username,pwd,regTime) values (?,?,?)"; //?为占位符

            PreparedStatement ps=conn.prepareStatement(sql);
            ps.setString(1,"ccqqqyyy");  //参数索引从1开始，对应着第1个问号
            ps.setObject(2,"12456");   // 也可以直接使用Object
            ps.setDate(3,new java.sql.Date(System.currentTimeMillis()));

           // ps.execute(); //返回boolean类型的值，用来表示是否查找到了数
            int num=ps.executeUpdate();     //代表着影响（insert，delete，update）了几行记录（现在是1行）
            System.out.println(num);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

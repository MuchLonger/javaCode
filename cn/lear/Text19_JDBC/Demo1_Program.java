package cn.lear.Text19_JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @description: 测试与数据库建立连接
 * @Time: 2018/8/27 18:22
 */
public class Demo1_Program {
    public static void main(String[] args) {
        try {
            /*            加载驱动类              */
            Class clazz = Class.forName("com.mysql.jdbc.Driver"); //里面的内容是固定的
            /*            获得Connection对象，建立连接（这样连接对象因为要建立Socket对象，会比较耗时，后期开发都是使用连接池来做的              */
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/textjdbc", "root", "123456");
            System.out.println(conn);






        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}

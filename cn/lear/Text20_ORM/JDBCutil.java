package cn.lear.Text19_JDBC;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

/**
 * @description: 自制JDBC工具类
 * @Time: 2018/8/28 13:36
 */
public class JDBCutil {
    //帮助读取和处理 资源文件（properties） 信息
    static Properties pros=null;
    static {
        pros=new Properties();
        try {
            pros.load(new FileReader("D:\\_java\\src\\database.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //获得mysql的连接
    public static Connection getMysqlConn() {
        try {

            Class.forName(pros.getProperty("mysqlDriver"));
            Connection conn = DriverManager.getConnection(pros.getProperty("mysqlURL"),
                    pros.getProperty("mysqlUser"), pros.getProperty("mysqlPwd"));

            return conn;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    //下面三个都是关闭方法的重载
    public static void closeIts(ResultSet rs, Statement ps, Connection conn) {
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

    public static void closeIts(Statement ps, Connection conn) {
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

    public static void closeIts(Connection conn) {
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


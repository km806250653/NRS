package cn.hncu.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtils {
    private static DataSource ds = null;

    static {
        Properties pro = new Properties();
//        InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
        try {
//            pro.load(is);
            pro.put("driverClassName","com.mysql.jdbc.Driver");
            pro.put("url","jdbc:mysql://127.0.0.1:3306/nrs");
            pro.put("username","root");
            pro.put("password","123");
            pro.put("initialSize","5");
            pro.put("maxActive","10");
            pro.put("maxWait","3000");
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource() {
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    public static void close(Connection con, Statement sta) {
        close(con, sta, null);
    }

    public static void close(Connection con, Statement sta, ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (sta != null) {
            try {
                sta.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (con != null) {
            try {
                con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}

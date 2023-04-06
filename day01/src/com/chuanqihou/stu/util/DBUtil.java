package com.chuanqihou.stu.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author 传奇后
 * @date 2023/3/13 11:01
 * @description
 */
public final class DBUtil {
    public static String driverClassName;
    public static String url;
    public static String username;
    public static String password;

    private DBUtil() {}

    static {
        try {
            Properties pro = new Properties();
            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
            driverClassName = pro.getProperty("driverClassName");
            url = pro.getProperty("url");
            username = pro.getProperty("username");
            password = pro.getProperty("password");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection() {
        Connection connection = null;
        try {
            Class.forName(driverClassName);
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static Connection getConnectionByDruid() {
        Connection connection = null;
        try {
            Properties pro = new Properties();
            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
            DataSource dataSource = DruidDataSourceFactory.createDataSource(pro);
            connection = dataSource.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close(AutoCloseable ac){
        if (ac != null) {
            try {
                ac.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}

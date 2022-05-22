package ucd.express;

import java.sql.*;


public class JDBCTool {

    public static Connection getConnection(String url, String dbname, String username, String password) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://" + url + "/" + dbname + "?" + "user=" + username + "&password=" + password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getConnection() {
        return JDBCTool.getConnection("182.92.215.108", "express_db", "express_db", "nRm7ywkfdHADWXa2");
    }
}
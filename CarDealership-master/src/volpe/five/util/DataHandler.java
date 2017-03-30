package volpe.five.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataHandler {

    private final static String jdbcUrl = "jdbc:mysql://localhost:8889/CarDealership";
    private final static String user = "root";
    private final static String password = "root";
    private static Connection conn;

    private static void connect() throws Exception {
        conn = DriverManager.getConnection(jdbcUrl, user, password);
    }
    public static Connection getConnection() throws Exception {
        if (conn == null || conn.isClosed()) {
            connect();
        }
        return conn;
    }
    public static void killConnection() throws SQLException {
        if (conn != null && !conn.isClosed()) {
            conn.close();
        }
    }

    public static String getWrappedValue(String value) {
        return "'" + value + "'";
    }
}

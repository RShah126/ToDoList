package Shah.DB;

import java.util.Properties;
import java.sql.*;

public class DBSupport {

    public static Connection establishConnection() throws SQLException, ClassNotFoundException {
        Properties connectProp = new Properties();
        connectProp.put("user", "root");
        connectProp.put("password", "hiddenpass!");
        connectProp.put("useSSL", "false");

        String jdbcUrl = "jdbc:mysql://localhost:3306/MainDB";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(jdbcUrl, connectProp);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error establishing database connection:");
            e.printStackTrace();
            throw e; 
        }
    }

    public static void executeQuery(String q) throws SQLException, ClassNotFoundException {
        try (Connection conn = establishConnection();
             Statement statement = conn.createStatement()) {
            statement.execute("USE MainDB");
            statement.execute(q);
        }
    }
}

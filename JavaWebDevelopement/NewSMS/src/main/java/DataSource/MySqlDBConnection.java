package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySqlDBConnection {
    private Connection connection;

    // Constructor
    public MySqlDBConnection() throws ClassNotFoundException, SQLException {
        // Load MySQL JDBC Driver
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("Driver Loaded");

        // Establish Connection
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/techm", "root", "Akash@123");
        System.out.println("Connection Established");
    }

    // Getter for Connection
    public Connection getConnection() {
        return connection;
    }

    // Setter for Connection (Optional)
    public void setConnection(Connection connection) {
        this.connection = connection;
    }

    // Main Method for Testing
    public static void main(String[] args) {
        try {
            MySqlDBConnection db = new MySqlDBConnection();
            Connection conn = db.getConnection();
            if (conn != null) {
                System.out.println("Database Connected Successfully!");
            } else {
                System.out.println("Failed to Connect to Database!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

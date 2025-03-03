package DatabaseConfig;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String connectionURL = "jdbc:mysql://localhost:3308/integratewithdatabaseudemy";
		String connectionUsername = "root";
		String connectionPassword = "Akash@123";

		try {
			// Load MySQL JDBC Driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			// Establish Connection
			connection = DriverManager.getConnection(connectionURL, connectionUsername, connectionPassword);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}

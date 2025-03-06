package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConfiguration {
	private static String JDBC_URL = "jdbc:mysql://localhost:3308/curdoperations";
	private static String JDBC_USERNAME = "root";
	private static String JDBC_PASSWORD = "Akash@123";
	private static String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	

	public static Connection getConnection() {
		Connection connection = null;
		try {
			System.out.println("Loading driver...");
			Class.forName(JDBC_DRIVER);
			System.out.println("Driver Loaded, Connecting to database...");
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USERNAME, JDBC_PASSWORD);
			System.out.println("Database connected successfully");
		} catch (SQLException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Connection failed");
			e.printStackTrace();
		}
		return connection;
	}

}

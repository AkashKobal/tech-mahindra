package Models;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import DatabaseConfig.MySQLConnection;
import Entity.User;

public class UserModel {
	
//	public List<User> listUser() {
//	    List<User> listUser = new ArrayList<>();
//	    String query = "SELECT * FROM users";
//
//	    try (Connection connection = MySQLConnection.getConnection();
//	         Statement statement = connection != null ? connection.createStatement() : null;
//	         ResultSet resultSet = statement != null ? statement.executeQuery(query) : null) {
//
//	        if (connection == null || statement == null || resultSet == null) {
//	            System.out.println("Database connection or statement failed.");
//	            return listUser;
//	        }
//
//	        while (resultSet.next()) {
//	            User user = new User(resultSet.getInt("userId"), resultSet.getString("username"),
//	                    resultSet.getString("email"));
//	            listUser.add(user);
//	        }
//
//	    } catch (SQLException e) {
//	        e.printStackTrace();
//	    }
//	    return listUser;
//	}

	
	public List<User> listUser() {
		List listUser = new ArrayList<User>();
		// 1. initializing the connection object
		Connection connection = MySQLConnection.getConnection();

		// Create statement object is used to execute SQL queries
		Statement statement = null;

		// ResultSet object is used to store the result of the executed query
		ResultSet resultSet = null;

		// 2.Creating the SQL query
		String query = "SELECT * FROM users";

		try {
			statement = connection.createStatement();
			// 3. Execution of statement
			resultSet = statement.executeQuery(query);

			// 4. Process the result
			while (resultSet.next()) {
				// 5. Create a new user object for each row in the result set and set the
				// properties of the user object
				// resultSet.getInt("colum_name") is used to get the value of the column from
				// the result set
				User user = new User(resultSet.getInt("userId"), resultSet.getString("username"),
						resultSet.getString("email"));
				// 6. Add the user object to the listUser
				listUser.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listUser;
	} 

}

package Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import DatabaseConfig.MySQLConnection;
import Entity.User;

public class CURDOperations {
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

	// add user
	public void addUser(String name, String email) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = MySQLConnection.getConnection();
			String insertQuery = "INSERT INTO users(username, email) VALUES(?,?)";
			statement = connect.prepareStatement(insertQuery);
			statement.setString(1, name);
			statement.setString(2, email);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// update user
	public void updateUser(User updateUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = MySQLConnection.getConnection();
			int userId = updateUser.getUserId();
			String username = updateUser.getUsername();
			String email = updateUser.getEmail();
			String updateQuery = "UPDATE users SET username = ?, email = ? WHERE userId = ?";
			statement = connect.prepareStatement(updateQuery);
			statement.setString(1, username);
			statement.setString(2, email);
			statement.setInt(3, userId);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// delete user
	public void deleteUser(User deleteUser) {
		Connection connect = null;
		PreparedStatement statement = null;
		try {
			connect = MySQLConnection.getConnection();
			int userId = deleteUser.getUserId();
			String deleteQuery = "DELETE FROM users WHERE userId = ?";
			statement = connect.prepareStatement(deleteQuery);
			statement.setInt(1, userId);
			statement.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

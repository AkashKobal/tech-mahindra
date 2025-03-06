package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Config.MySQLConfiguration;
import Model.RegisterUser;

public class UserRegisterController {
//	name,email,password,gender,country
	private static final String INSERT_USER_QUERY = "INSERT INTO course(coursename,fees,category,duration) VALUES(?,?,?,?)";
	private static final String SELECT_USER_BY_ID = "SELECT id,name,email,country FROM users WHERE id=?";
	private static final String SELECT_ALL_USERS = "SELECT	* FROM users";
	private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id=?";
	private static final String UPDATE_USER_BY_ID = "UPDATE users SET name=?,email=?,country=? WHERE id=?";

	Connection connection = null;
	
	public UserRegisterController() throws ClassNotFoundException {
		connection = MySQLConfiguration.getConnection();
	}
	
	public void registerUser(RegisterUser user) {
		try {
			PreparedStatement ps = connection.prepareStatement(INSERT_USER_QUERY);
			ps.setString(1,user.getName() );
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPassword());
			ps.setString(4, user.getGender());
			ps.setString(5, user.getCountry());
			ps.executeUpdate();
			System.out.println("User Registered Successfully!");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void registerUser(String name, String email, String password, String gender, String country) {
		
	}
	
	
	
	
	

}

package Servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import Controller.UserRegisterController;


@WebServlet("/RegistrationForm")
public class RegistrationForm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	name,email,password,gender,country
		String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        
        PrintWriter out = response.getWriter();
        
        System.out.println("Name: "+name+
        		" Email: "+email+
        		" Password: "+password+
        		"Gender: "+gender+
        		"Country: "+country);
        
        try {
			UserRegisterController userRegisterController = new UserRegisterController();
			userRegisterController.registerUser(name, email, password, gender, country);
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        /*
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
        	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3308/registrationformdb","root","Akash@123");
        	PreparedStatement ps = con.prepareStatement("insert into register(name,email,password,gender,country) values(?,?,?,?,?)");
        	ps.setString(1, name);
        	ps.setString(2, email);
        	ps.setString(3, password);
        	ps.setString(4, gender);
        	ps.setString(5, country);
        	
        	int i = ps.executeUpdate();
        	if(i>0) {
        		response.setContentType("text/html");
        		out.print("<h1 style='color:green'> Data Inserted Successfully</h1>");
        		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
        		rd.include(request, response);
        		
        		System.out.println("Data Inserted Successfully");
        		}else {
        			response.setContentType("text/html");
            		out.print("<h1 style='color:red'> Data Not Inserted</h1>");
            		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
            		rd.include(request, response);
            		
        			System.out.println("Data Not Inserted");
        		}
        	
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setContentType("text/html");
    		out.print("<h1 style='color:red'> Exception Occured</h1>");
    		RequestDispatcher rd = request.getRequestDispatcher("/register.jsp");
    		rd.include(request, response);
    		
			System.out.println("Data Not Inserted");
		}
		
		*/
		
	}

}

package com.example;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/SiteController")
public class SiteController extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
    public SiteController() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		if(name.equals("akash") && password.equals("123456")) {
			request.getSession().invalidate(); // first invalidate the session if any exists before creating a new one
			HttpSession newSession = request.getSession();
			newSession.setMaxInactiveInterval(500); // 50 seconds
//			Cookie cookie = new Cookie("name", name); // create a cookie (name,value)
//			response.addCookie(cookie); // add the cookie to the response
			newSession.setAttribute("name", name); // set the session attribute
			
			response.sendRedirect("member.jsp");
		}
		else {
			response.sendRedirect("login.jsp");
		}
	
	}

}

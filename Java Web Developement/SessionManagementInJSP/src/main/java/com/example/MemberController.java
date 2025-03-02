package com.example;

import jakarta.servlet.ServletException; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public MemberController() {
        super();
    }

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String logout = req.getParameter("logout");
		
		switch (logout) {
		case "logout":{
			req.getSession().invalidate();
			
			/*
			Cookie[] cookies = req.getCookies();
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("name")) {
					cookie.setMaxAge(0);
					resp.addCookie(cookie);
				}
			}
			*/
			resp.sendRedirect("login.jsp");
		}
		
		}
			
	}

}

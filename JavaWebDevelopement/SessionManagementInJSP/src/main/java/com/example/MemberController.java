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
		String action = req.getParameter("action");
		
		switch (action) {
		case "logout":{
			req.getSession().invalidate();
			resp.sendRedirect(req.getContextPath()+"/SiteController?action=login");
			break;
		}
		case "member":{
			req.getRequestDispatcher("member.jsp").forward(req, resp);
			break;

		}
		
		}
			
	}

}

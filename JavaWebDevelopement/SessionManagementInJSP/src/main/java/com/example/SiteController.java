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

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = req.getParameter("action");
		if (action != null) {
			switch (action) {
			case "login": {
				req.getRequestDispatcher("login.jsp").forward(req, resp);
				break;
			}
			case "logout": {
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate(); // Destroy session
				}
				resp.sendRedirect(req.getContextPath() + "/login.jsp"); // Redirect to login
				break;
			}
			default: {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			}
		} else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
	}

	protected void authenticate(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name = request.getParameter("name");
		String password = request.getParameter("password");

		if (name.equals("akash") && password.equals("123456")) {
			request.getSession().invalidate(); // first invalidate the session if any exists before creating a new one
			HttpSession newSession = request.getSession();
			newSession.setMaxInactiveInterval(500); // 50 seconds
			newSession.setAttribute("name", name); // set the session attribute
			response.sendRedirect(request.getContextPath() + "/MemberController?action=member");
		} else {
			response.sendRedirect(request.getContextPath() + "/SiteController?action=login");
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String action = req.getParameter("action");
		if (action != null) {
			switch (action) {
			case "authenticate": {
				authenticate(req, resp);
				break;
			}
			case "logout": {
				HttpSession session = req.getSession(false);
				if (session != null) {
					session.invalidate(); // Destroy session
				}
				resp.sendRedirect(req.getContextPath() + "/login.jsp"); // Redirect to login
				break;
			}
			default: {
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			}
		} else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}

	}

}

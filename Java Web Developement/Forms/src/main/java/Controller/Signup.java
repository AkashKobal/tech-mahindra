package Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/Signup")
public class Signup extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Signup() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		response.getWriter().println(request.getParameter("fname"));
		response.getWriter().println(request.getParameter("lname"));
		response.getWriter().println(request.getParameter("email"));
		response.getWriter().println(request.getParameter("password"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		response.getWriter().println(request.getParameter("fname"));
		response.getWriter().println(request.getParameter("lname"));
		response.getWriter().println(request.getParameter("email"));
		response.getWriter().println(request.getParameter("password"));

	}

}

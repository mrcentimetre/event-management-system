package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("uid");
		String password = request.getParameter("pass");


		try {
			List<customize> cusDetails = CustomerDBUtil.validate(username, password);

			if (cusDetails != null && !cusDetails.isEmpty()) {
				// Create session and store user info
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				session.setAttribute("password", password);
				session.setAttribute("cusDetails", cusDetails);
				session.setMaxInactiveInterval(30 * 60); // 30 minutes

				// Redirect to event view page
				response.sendRedirect("eventView.jsp");
			} else {
				// Login failed - no events found for this user
				request.setAttribute("errorMessage", "Invalid username or password");
				RequestDispatcher dis = request.getRequestDispatcher("userLogin.jsp");
				dis.forward(request, response);
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}

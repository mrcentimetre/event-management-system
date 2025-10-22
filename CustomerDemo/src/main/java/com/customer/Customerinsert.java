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

@WebServlet("/Customerinsert")
public class Customerinsert extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String planner = request.getParameter("planner");
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		boolean isTrue;

		isTrue = CustomerDBUtil.insertevent(name, type, description, date, time, location, planner, username, password);

		if (isTrue == true) {
			// Check if user is logged in
			HttpSession session = request.getSession(false);
			String sessionUsername = (session != null) ? (String) session.getAttribute("username") : null;

			if (sessionUsername != null) {
				// User is logged in - refresh their event list and redirect to eventView.jsp
				try {
					List<customize> cusDetails = CustomerDBUtil.validate(username, password);
					session.setAttribute("cusDetails", cusDetails);
					response.sendRedirect("eventView.jsp");
				} catch (Exception e) {
					e.printStackTrace();
					RequestDispatcher dis = request.getRequestDispatcher("eventSuccess.jsp");
					dis.forward(request, response);
				}
			} else {
				// User is not logged in - show success page
				RequestDispatcher dis = request.getRequestDispatcher("eventSuccess.jsp");
				dis.forward(request, response);
			}
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("eventUnsuccess.jsp");
			dis2.forward(request, response);

		}
	}

}

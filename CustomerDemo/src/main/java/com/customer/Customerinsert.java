package com.customer;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			RequestDispatcher dis = request.getRequestDispatcher("eventSuccess.jsp");
			dis.forward(request, response);
		} else {
			RequestDispatcher dis2 = request.getRequestDispatcher("eventUnsuccess.jsp");
			dis2.forward(request, response);
			
		}
	}

}

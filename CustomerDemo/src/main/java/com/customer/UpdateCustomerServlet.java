package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/UpdateCustomerServlet")
public class UpdateCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eventid = request.getParameter("eventid");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String planner = request.getParameter("planner");
		
		boolean isTrue;
		
		isTrue = CustomerDBUtil.updateEvent(eventid, name, type, date, time, location, planner);
	
		if (isTrue == true) {
			
			List<customize> cusDetails = CustomerDBUtil.getCustomerDetails(eventid);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis = request.getRequestDispatcher("eventView.jsp");
			dis.forward(request, response);
		}
		else {
			List<customize> cusDetails = CustomerDBUtil.getCustomerDetails(eventid);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dis2 = request.getRequestDispatcher("eventView.jsp");
			dis2.forward(request, response);
		}
	}

}

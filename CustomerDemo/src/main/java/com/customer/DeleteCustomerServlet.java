package com.customer;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteCustomerServlet")
public class DeleteCustomerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String eventid = request.getParameter("eventid");
		boolean isTrue;
		
		isTrue = CustomerDBUtil.deleteEvent(eventid);
		
		if (isTrue == true) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("eventRegistration.jsp");
			dispatcher.forward(request, response);
		}
		else {
			List<customize> cusDetails = CustomerDBUtil.getCustomerDetails(eventid);
			request.setAttribute("cusDetails", cusDetails);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("eventView.jsp");
			dispatcher.forward(request, response);
		}
	}

}

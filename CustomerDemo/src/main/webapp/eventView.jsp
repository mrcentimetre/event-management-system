<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>My Events - Event Management System</title>
  <link rel="stylesheet" href="style1.css">
</head>
<body>

<nav>
        <div class="container">
          <a href="#" class="logo">Event Management</a>
          <ul class="nav-links">
            <li><a href="#">Home</a></li>
            <li><a href="#">About</a></li>
            <li><a href="#">Services</a></li>
            <li><a href="#">Contact</a></li>
            <li><a href="userLogin.jsp">Log in</a></li>
          </ul>
        </div>
    </nav>


	<c:forEach var="cus" items="${cusDetails}">
	
	<h1>My Events</h1>
	
	<a href="eventRegistration.jsp">
	<input type="button" style="margin:0px 0px 0px 80%;" class="glowing-orange-button" name="update" value="Create Event">
	</a>
	
	<c:set var="eventid" value="${cus.eventid}"/>
	<c:set var="name" value="${cus.name}"/>
	<c:set var="email" value="${cus.type}"/>
	<c:set var="date" value="${cus.date}"/>
	<c:set var="time" value="${cus.time}"/>
	<c:set var="location" value="${cus.location}"/>
	<c:set var="planner" value="${cus.planner}"/>
	
	<table id="customers">
  <tr>
    <th>Event ID</th>
    <th>Event Name</th>
    <th>Event Type</th>
    <th>Date</th>
    <th>Time</th>
    <th>City</th>
    <th>Planner</th>
    <th></th>
  </tr>
  <tr>
    <td>${cus.eventid}</td>
    <td>${cus.name}</td>
    <td>${cus.type}</td>
    <td>${cus.date}</td>
    <td>${cus.time}</td>
    <td>${cus.location}</td>
    <td>${cus.planner}</td>
    <td>
    <c:url value="eventUpdate.jsp" var="cusupdate">
		<c:param name="eventid" value="${eventid}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="type" value="${type}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="time" value="${time}"/>
		<c:param name="location" value="${location}"/>
		<c:param name="planner" value="${planner}"/>
	</c:url>
	
	<a href="${cusupdate}">
	<input type="button" class="glowing-button" name="update" value="Edit">
	</a>
	
	<c:url value="eventDelete.jsp" var="cusdelete">
		<c:param name="eventid" value="${eventid}"/>
		<c:param name="name" value="${name}"/>
		<c:param name="type" value="${type}"/>
		<c:param name="date" value="${date}"/>
		<c:param name="time" value="${time}"/>
		<c:param name="location" value="${location}"/>
		<c:param name="planner" value="${planner}"/>
	</c:url>
	
	<a href="${cusdelete}">
	<input type="button" class="glowing-red-button" name="delete" value="Delete">
	</a>
    
    </td>
  </tr>
</table>
	
	</c:forEach>
	
	
	<footer>
    <p>Copyright &copy; 2023 Event Management System. All rights reserved.</p>
  </footer>
	
	
</body>
</html>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event - Event Management System</title>
  <link rel="stylesheet" href="style1.css">
</head>
<body>

	<%
		String eventid = request.getParameter("eventid");
		String name = request.getParameter("name");
		String type = request.getParameter("type");
		String date = request.getParameter("date");
		String time = request.getParameter("time");
		String location = request.getParameter("location");
		String planner = request.getParameter("planner");
	%>
	
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
	
	<div class="form-container">
	<br><br>
	<form action="update" method="post">
		
		<h1> Edit Event</h1>
	<p>Event ID:</p>
    <input type="text" name="eventid" value="<%= eventid %>" readonly><br>
    <p>Event Name:</p>
    <input type="text" name="name" value="<%= name %>"><br>
    <p>Event Type:</p>
    <select name="type" >
    <option value="wedding>">Wedding</option>
    <option value="birthday_party">Birthday Party</option>
    <option value="conference">Conference</option>
    <option value="get_together">Get-Together</option>
  </select><br>
  	<p>Event Date:</p>
  	<input type="date" name="date" value="<%= date %>"><br>
  	<p>Event Time:</p>
  	<input type="time" name="time" value="<%= time %>"><br>
    <p>Event Location:</p>
	<input type="text" name="location" value="<%= location %>"><br>
	<p>Event Planner:</p>
    <select name="planner">
		<option value="colin_cowie">Colin Cowie</option>
		<option value="mindy_weiss">Mindy Weiss</option>
		<option value="david_tutera">David Tutera</option>
		<option value="preston_bailey">Preston Bailey</option>
		<option value="bassett_events">Bassett Events</option>
		<option value="mkgevent">MKG</option>
		<option value="aperfectevent">A Perfect Event</option>
		<option value="other">Other</option>
	</select><br><br>
	
	<input type="submit" name="submit" value="Update My Data"><br>
		
	</form>
	<br>
	</div>

	<footer>
    <p>Copyright &copy; 2023 Event Management System. All rights reserved.</p>
  </footer>

</body>
</html>
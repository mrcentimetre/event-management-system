<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
  <title>Create Event - Event Management System</title>
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

 <div class="form-container">
<br><br>
  <form action="insert" method="post">
    <h1> Create Event</h1>
    <p>Event Name:</p>
    <input type="text" name="name" placeholder="Enter Event name"><br>
    <p>Event:</p>
    <select name="type">
    <option value="wedding">Wedding</option>
    <option value="birthday_party">Birthday Party</option>
    <option value="conference">Conference</option>
    <option value="get_together">Get-Together</option>
  </select><br>
  	<p>Event Date:</p>
  	<input type="date" name="date" id="date"><br>
  	<p>Event Time:</p>
  	<input type="time" name="time"><br>
    <p>Event Location:</p>
	<input type="text" name="location"><br>
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
	</select><br>
	<p>Username:</p>
	<input type="text" name="username" required><br>
	<p>Password:</p>
 	<input type="password" name="password" minlength="4" required><br><br>
	
	<input type="submit" name="submit" value="Submit">
  </form>
	<br>
	</div>


  <footer>
    <p>Copyright &copy; 2023 Event Management System. All rights reserved.</p>
  </footer>
</body>
</html>

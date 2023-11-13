<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login - Event Management System</title>

<link rel="stylesheet" href="style.css">

</head>
<body>


	<div class="form-container">
	<form action="log" method="post">
	<h3>Hi, Welcome!</h3>
		<br>
		<input type="text" name="uid" required placeholder="Enter Your Username">
		<br>
		<input type="password" name="pass" minlength="4" required placeholder="Enter Your Password">
		
		<input type="submit" name="submit" value="login" class="form-btn">
		
		<h5>Didn't you register? <a href="eventRegistration.jsp">Create an Event & Register Now</a></h5>
	</form>
	</div>
</body>
</html>
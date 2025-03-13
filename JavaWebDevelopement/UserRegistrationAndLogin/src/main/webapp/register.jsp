<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Registration</title>
</head>
<body>

	<form action="RegistrationForm" method="post">
		<h2>Name:</h2>
		<input type="text" name="name"/><br>
		<h2>Email:</h2>
		<input type="text" name="email"/><br>
		<h2>Password:</h2>
		<input type="password" name="password"/><br>
		<h2>Gender:</h2>
		<input type="radio" name="gender" value="Male"/>Male <input type="radio"
			name="gender" value="Female"/>Female
		<h2>Country:</h2>
		<select name="country">
			<option>India</option>
			<option>USA</option>
			<option>UK</option>
			<option>Other</option>
		</select><br>
		<input type="submit" value="Register"/>
	</form>
</body>
</html>
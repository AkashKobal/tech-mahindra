<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>set Property</title>
</head>
<body>
<jsp:useBean id="user" class="User.User" scope="session"></jsp:useBean>
First Name : <jsp:setProperty property="fname" name="user" value="John"/><br>
Last Name : <jsp:setProperty property="lname" name="user" value="Monk"/><br>
Value set successfully
</body>
</html>
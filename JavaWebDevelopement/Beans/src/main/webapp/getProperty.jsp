<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>get Property</title>
</head>
<body>

<jsp:useBean id="user" class="User.User" scope="application"></jsp:useBean>
First Name : <jsp:getProperty property="fname" name="user"/><br>
Last Name : <jsp:getProperty property="lname" name="user"/>

</body>
</html>
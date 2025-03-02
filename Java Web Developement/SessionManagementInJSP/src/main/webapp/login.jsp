<%@page import="com.example.SiteController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
<h1>Login</h1>
<form action="<%=request.getContextPath()%>/SiteController" method ="post">
<h3>Name :</h3><input type="text" name="name"/><br>
<h3>Password :</h3><input type="password" name="password"/><br> <br>
<input type="submit" value="Submit"/>
</form>

</body>
</html>
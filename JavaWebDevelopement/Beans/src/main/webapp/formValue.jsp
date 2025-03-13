<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Set Property</title>
</head>
<body>
Values submitted to forms.<br>
<jsp:useBean id="user" class="User.Form" scope="session"></jsp:useBean>
<jsp:setProperty property="*" name="user"/>
First Name : <jsp:getProperty property="fname" name="user"/><br>
Last Name : <jsp:getProperty property="lname" name="user"/>

</body>
</html>
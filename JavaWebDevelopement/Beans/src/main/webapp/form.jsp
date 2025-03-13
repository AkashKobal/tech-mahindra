<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Get Property</title>
</head>
<body>
<jsp:useBean id="user" class="User.Form" scope="session"></jsp:useBean>
<form action="formValue.jsp">
Submit form <br>
First Name : <input type="text" name="fname" value="<jsp:getProperty property="fname" name="user"/>"/><br>
Last Name : <input type="text" name="lname" value="<jsp:getProperty property="lname" name="user"/>"/><br>
<input type="submit" value="Submit"/>
</form>

</body>
</html>
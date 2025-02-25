<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello JSP</title>
</head>
<body>
	<h1>Hello JSP</h1>
	<% out.print("welcome to jsp"); %>  <br>
	<% out.print("This is a JAVA Scripting element"); %>
	<h2>Taking input from user using HTML</h2>
	<form action="HelloJsp.jsp" method="post">
        Enter your name: <input type="text" name="name"> <br> <br>
        Enter your age: <input type="text" name="age"> <br>
        <input type="submit" value="Submit">
        </form> <br>
        
     <% out.print("Displaying output user input using Java scripting element"); %> <br>
     
     <% String name = request.getParameter("name"); %>
     
     <% String age = request.getParameter("age"); %>
     
    <h3> <% out.print("Welcome :"+name+"<br>"+"Your age is :"+age); %></h3>
</body>
</html>
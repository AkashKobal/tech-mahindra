<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Declaration Elements</title>
</head>
<body>
<h1>Declaration Elements</h1>

<!-- Declaration Element using JSP elements -->
<% String name = "Akash"; %>

<%="Hello : "+name %>

<h3>Creating a method and calling the declared variable</h3>
<% String company = "techM"; %>

<%! String company(){
	return "tehM"; 
}
	%>
	
<%=company() %>
</body>
</html>
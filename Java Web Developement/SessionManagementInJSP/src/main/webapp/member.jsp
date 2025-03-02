<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Member</title>
</head>
<body>
<h1>Member Page</h1>

<%
String name = null, sessionId = null;
   
if(request.getSession().getAttribute("name") == null) {
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
    else{
    	        name = request.getSession().getAttribute("name").toString();
    	        sessionId = request.getSession().getId();
    }

	
%>
<h3>Name: <%=name %></h3> <br>
<h3>SessionId: <%=sessionId %></h3>

<form action="<%=request.getContextPath()%>/MemberController" method="get">
<input type="hidden" name="action" value="logout">
<input type="submit" value="Logout">
</form>

</body>
</html>
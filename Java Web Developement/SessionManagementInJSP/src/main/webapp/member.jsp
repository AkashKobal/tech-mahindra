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


	// cookie are use to store client side data
	// cookie are object so we use [] to store multiple cookies
	
	/*
	Cookie[] cookies = request.getCookies(); // get all cookies available on the link(request)
	if(cookies != null) {
		for (Cookie cookie : cookies) {
	if (cookie.getName().equals("name")) {
		name = cookie.getValue();
	}
	if (cookie.getName().equals("JSESSIONID")) { // JSESSION is a default cookie which is created by server
		sessionId = cookie.getValue();
	}
		}
	}
	
	if(sessionId == null || name == null){
		response.sendRedirect(request.getContextPath() + "/login.jsp");
	}
	*/
	
%>
<h3>Name: <%=name %></h3> <br>
<h3>SessionId: <%=sessionId %></h3>

<form action="<%=request.getContextPath()%>/MemberController" method="get">
<input type="hidden" name="logout" value="logout">
<input type="submit" value="Logout">
</form>

</body>
</html>
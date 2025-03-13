<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Include File</h1>
<%-- Include file1.txt and file2.txt 
This is a static include directive. used to include static files.
--%>
<%@ include file = "file1.txt" %> <br>
<%@ include file = "file2.txt" %><br>

<%--including file using jsp:include tag
This is a Dynamic include. Used to include dynamic files.
  --%>
<jsp:include page="file1.txt"></jsp:include>
</body>
</html>
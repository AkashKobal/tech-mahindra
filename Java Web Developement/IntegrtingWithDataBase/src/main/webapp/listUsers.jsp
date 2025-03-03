<jsp:include page="/Components/NavBar.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="Entity.User"%>

<h1>List All Users From DataBase</h1>
<table class="table table-striped table-bordered">
	<thead class="table-dark">
		<tr>
			<th>User ID</th>
			<th>User Name</th>
			<th>Email</th>
		</tr>
	</thead>
	<tbody>
		<%
		List<User> listUser = (List<User>) request.getAttribute("listUsers");
		if (listUser != null && !listUser.isEmpty()) {
			for (User user : listUser) {
		%>
		<tr>
			<td><%=user.getUserId()%></td>
			<td><%=user.getUsername()%></td>
			<td><%=user.getEmail()%></td>
		</tr>
		<%
		}
		} else {
		%>
		<tr>
			<td colspan="3" class="text-center text-danger fw-bold">No users
				found</td>
		</tr>
		<%
		}
		%>
	</tbody>
</table>
<jsp:include page="Components/Footer.jsp" />

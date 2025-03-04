<jsp:include page="/Components/NavBar.jsp" />
<%@ page import="java.util.List"%>
<%@ page import="Entity.User"%>

<h1>List All Users From Database</h1>
<form action="<%=request.getContextPath() %>/AddUser" method="get">
    <h2>Name:</h2><input type="text" name="name" required/>
    <h2>Email:</h2><input type="email" name="email" required/>
    <input type="submit" value="Submit"/>
</form>
<br>
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
            <td><%= user.getUserId() %></td>
            <td><%= user.getUsername() %></td>
            <td><%= user.getEmail() %></td>
        </tr>
        <%
            }
        } else {
        %>
        <tr>
            <td colspan="3" class="text-center text-danger fw-bold">No users found</td>
        </tr>
        <%
        }
        %>
    </tbody>
</table>
<jsp:include page="Components/Footer.jsp" />


<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
     <%@ page import="com.example.web.model.User" %>
     <%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User List</title>
</head>
<body>
<% 
List<User> users=(List<User>)request.getAttribute("userlist"); 
%>
<table  class="table table-bordered">
<thead>
<tr>
<th align="center">User Name</th>
<th align="center">Email</th>
<th align="center">Mobile Number</th>
</tr>
</thead>
<tbody>
<%
for(User user:users)
{
%>
<tr>
<td align="center"><%=user.getName() %></td>
<td align="center"><%=user.getEmail() %></td>
<td align="center"><%=user.getMobile() %></td>
</tr>
<%} %>
</tbody>
</table>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="register">
<ul class="navbar-nav"> 
<li><a href="list.jsp" class="nav-link">User List</a></li>
</ul>
<h1 align="center">Welcome Our Home Page</h1>
<div align="center">
<div>
<input type="tel" placeholder="Enter your Name" name="name">
</div><br>
<div>
<input type="email" placeholder="Enter your Email" name="email">
</div><br>
<div>
<input type="tel" placeholder="Enter your Mobile Number" name="mobile">
</div><br>
<div>
<input type="submit" value="Register">
</div><br><br>
<div>
<a href="update.jsp">Update User Details</a>
</div><br><br>
<div><a href="delete.jsp">Delete User Details</a>
</div>
</div>
</form>
</body>
</html>
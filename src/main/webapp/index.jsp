<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<!DOCTYPE html>
<html>
<head>
<script src="/main/js/main.js"></script>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="register">
		
		<h1 align="center">Welcome Our Home Page</h1>
		<div align="center">
			<div>
				<label><i class="fas fa-file-signature"></i>&nbsp&nbsp&nbspUser
					Name:</label> <input id="name" type="text" class="form-control" name="name"
					placeholder="Enter User Name" required="required"> <label
					id="nm" style="color: red; visibility: hidden">Invalid User
					Name</label>
			</div><br>
			<div>
				<label><i class="fas fa-file-signature"></i>&nbsp&nbsp&nbsp
					Email:</label> <input id="email" type="text" class="form-control"
					name="email" placeholder="Enter Email" required="required">
				<label id="em" style="color: red; visibility: hidden">Invalid
					Email</label><br>
			</div><br>
			<div>
				<label><i class="fas fa-file-signature"></i>&nbsp&nbsp&nbspMobile
					Number:</label> <input id="mobile" type="text" class="form-control"
					name="mobile" placeholder="Enter the Mobile Number"
					required="required"> <label id="mb"
					style="color: red; visibility: hidden">Invalid Mobile
					Number</label><br>
			</div>
			<div>
				<input type="submit" value="Register">
			</div>
			<br>
			<br>
			<div>
				<a href="update.jsp">Update User Details</a>
			</div>
			<br>
			<br>
			<div>
				<a href="delete.jsp">Delete User Details</a>
			</div>
		</div>
	</form>
	<br>
	<div>
		<label id="user" style="color: green; visibility: hidden">valid
			User Details </label>
	</div>
	<div align="center">
		<form action="userlist">
			<button type="submit">User List</button>
		</form></div>
		<br>
		<div align="center">
		
		<form action="findUserbyEmail">
		<div>
				<label><i class="fas fa-file-signature"></i>&nbsp&nbsp&nbsp
					Email:</label> <input id="email" type="text" class="form-control"
					name="email" placeholder="Enter Email" required="required">
				<label id="em" style="color: red; visibility: hidden">Invalid
					Email</label><br>
			</div><br>
			<button type="submit">Find</button>
		</form>

	</div>
</body>
</html>
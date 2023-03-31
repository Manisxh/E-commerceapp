<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<title>Online Ecommerce Application -Profile</title>
</head>
<body>
	<jsp:include page="navbar.jsp"></jsp:include>
	<section class="container">
		<table class="table">
		<tr>
			<td>Name </td><th>${user.userFullName}</th>
		</tr>
		<tr>
			<td>Email </td><th>${user.userEmail}</th>
		</tr>
		<tr>
			<td>Password </td><th>${user.userPassword}</th>
		</tr>
		<tr>
			<td>Address </td><th>${user.userAddress}</th>
		</tr>
	</table>
	</section>

</body>
</html>
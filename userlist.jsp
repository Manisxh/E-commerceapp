<%@page import="com.shubham.ecom.pojo.User"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.3/font/bootstrap-icons.css">
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<title>Online Ecommerce Application</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<%
List<User> userlist =(List<User>)session.getAttribute("userlist");
%>
<div class="container">
<table class="table table-bordered table-hover">
<thead>
<tr>
<th>Id</th>
<th>Name</th>
<th>Email</th>
<th>Type</th>
<th>Address</th>
<th>Action</th>
</thead>
<tbody>
<%for (User u : userlist) {%>
<tr>
<td><%=u.getUserId() %></td>
<td><%=u.getUserFullName() %></td>
<td><%=u.getUserEmail() %></td>
<td><%=u.getUserType() %></td>
<td><%=u.getUserAddress() %></td>
<td><a onclick="return confirm('Are you sure do you want to delete this user')" href="user?action=delete&userId=<%=u.getUserId()%>" class="btn btn-outline-danger"><i class="bi bi-trash3"></i></a></td>
</tr>
<%}%>

</tbody>
</table>
</div>
</body>
</html>
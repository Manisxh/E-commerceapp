<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<script src="js/bootstrap.bundle.min.js" type="text/javascript"></script>
<title> Online Ecommerce Application</title>
</head>
<body>
<jsp:include page="navbar.jsp"></jsp:include>
<section class="container">
<form method="post" action="user" >
<input type="hidden" name="action" value="login">
  <div class="mb-3">
    <label for="userEmail" class="form-label">Email address</label>
    <input type="email" class="form-control" id="userEmail" name="userEmail">
  </div>
  <div class="mb-3">
    <label for="userPassword" class="form-label">Password</label>
    <input type="password" class="form-control" id="userPassword" name="userPassword">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</section>
</body>
</html>
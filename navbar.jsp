<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="core"%>

<nav class="navbar navbar-expand-lg bg-body-tertiary">
	<div class="container-fluid">
		<a class="navbar-brand" href="ecom?action=index">MyStore</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="ecom?action=index">Home</a></li>
				<li class="nav-item"><a class="nav-link" href="#">Link</a></li>
				<!-- <li class="nav-item"><a class="nav-link" href="user?action=customerlist">User List</a></li> -->
				<li class="nav-item"><a class="nav-link"
					href="ecom?action=about-us">About Us</a></li>
				<li class="nav-item"><a class="nav-link"
					href="ecom?action=contact-us">Contact Us</a></li>


			</ul>
			<div class="d-flex" role="search">
				<core:if test="${user==null}">
					<a class="btn btn-outline-primary mx-2" href="user?action=login">Login</a>
					<a class="btn btn-outline-primary mx-2" href="user?action=register">Register</a>
				</core:if>
				<core:if test="${user!=null}">
					<div class="btn-group">
						<button class="btn btn-info btn-sm" type="button">
							${user.userFullName }</button>
						<button type="button"
							class="btn btn-sm btn-info dropdown-toggle dropdown-toggle-split"
							data-bs-toggle="dropdown" aria-expanded="false">
							<span class="visually-hidden">Toggle Dropdown</span>
						</button>
						<ul class="dropdown-menu">
							<core:if test="${user.userType == 'owner' }">
								<li><a class="dropdown-item" href="user?action=registeradmin">Add Admin</a></li>
							</core:if>
							<core:if test="${user.userType == 'owner' || user.userType == 'admin'}">
								<li>
									<a class="dropdown-item" href="user?action=customerlist">
										User List
									</a>
								</li>
								<li>
									<a class="dropdown-item"href="user?action=customerlist">
										Add Product 
									</a>
								</li>
							</core:if>

							<core:if test="${user.userType == 'customer'}">
								<li><a class="dropdown-item" href="#">ViewCart</a></li>
							</core:if>
							<li><a class="dropdown-item" href="profile.jsp">Profile</a></li>
							<li><hr class="dropdown-divider"></li>
							<li><a class="dropdown-item" href="user?action=logout">
									logout1 
							</a></li>
						</ul>
					</div>
				</core:if>
			</div>
		</div>
	</div>
</nav>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Project Manager</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="pt-3 px-4">
	
		<div class="text-center">
			<h1 class="text-primary mb-3">Course Platform - Instructors</h1>
		</div>
		
		<div class="row">
		
			<h3 class="mb-3">New Instructor</h3>
			
			<div class="col">
			
			<form:form action="/register" method="post" modelAttribute="user">
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-5 col-form-label" path="username">Name:</form:label>
					<form:input class="col-sm-7" type="text" path="username" />
					<form:errors class="text-danger" path="username"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-5 col-form-label" path="email">Email:</form:label>					
					<form:input class="col-sm-7" type="text" path="email" />
					<form:errors class="text-danger" path="email"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-5 col-form-label" path="password">Password:</form:label>
					<form:input class="col-sm-7" type="password" path="password" />
					<form:errors class="text-danger" path="password"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-5 col-form-label" path="confirm">Confirm PW:</form:label>
					<form:input class="col-sm-7" type="password" path="confirm"></form:input>
					<form:errors class="text-danger" path="confirm"></form:errors>
				</div>
				
				<div class="text-end">
					<input class="btn btn-primary" type="submit" value="Register" />
				</div>
			
			</form:form>
	
			</div>
		
		
			<!-- Login Form ------------------- -->
			
			<div class="col">
				<form:form action="/login" method="post" modelAttribute="loginUser">
			
				<h3 class="mb-3">Login</h3>
			
				<div class="form-group mb-3 row">
					<form:label class="col-sm-5 col-form-label" path="email">Email:</form:label>					
					<form:input class="col-sm-7" type="email" path="email" />
					<form:errors class="text-danger" path="email"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-5 col-form-label" path="password">Password:</form:label>
					<form:input class="col-sm-7" type="password" path="password" />
					<form:errors class="text-danger" path="password"></form:errors>
				</div>
				
				<div class="text-end">
					<input class="btn btn-success" type="submit" value="Login" />
				</div>
			
			</form:form>
		
			</div>
			
			
		</div>
		
	</div>

</body>
</html>
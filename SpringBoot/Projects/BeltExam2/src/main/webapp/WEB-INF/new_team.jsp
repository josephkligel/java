<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

<title>Kickball League Dashboard</title>
</head>
<body>
	<div class="container pt-3">
	
		<div class="mb-3">
			<h1 class="mb-3">New Team</h1>
			<a href="/home">dashboard</a>
		</div>
		
		<form:form action="/teams" method="post" modelAttribute="team">
		
				<form:input type="hidden" value="${user.id }" path="user" />
			
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="teamName">Team Name:</form:label>					
					<form:input class="col-sm-8" type="text" path="teamName" />
					<form:errors class="text-danger" path="teamName"></form:errors>
				</div>
				
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="skillLevel">Skill Level (1-5):</form:label>
					<form:input class="col-sm-8" type="number" min="1" max="5" path="skillLevel" />
					<form:errors class="text-danger" path="skillLevel"></form:errors>
				</div>
				
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="gameDay">Game Day:</form:label>
					<form:select class="col-sm-8" path="gameDay">
						<option></option>
						<option>Monday</option>
						<option>Tuesday</option>
						<option>Wednesday</option>
						<option>Thursday</option>
						<option>Friday</option>
						<option>Saturday</option>
						<option>Sunday</option>
					</form:select>
					<form:errors class="text-danger" path="gameDay"></form:errors>
				</div>
				
				<div>
					<button class="btn btn-outline-dark w-100 btn-outline-light shadow">Submit</button>
				</div>
		
		</form:form>
		
	</div>

</body>
</html>
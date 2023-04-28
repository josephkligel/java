<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="py-5 w-50 m-auto">
	
		<div class="mb-5">
			<h1 class="mb-5">Burger Tracker</h1>
			
			<table class="table table-striped">
				<thead class="table-secondary">
					<tr>
						<th>ID</th>
						<th>Burger Name</th>
						<th>Restaurant Name</th>
						<th>Rating (out of 5)</th>
						<th>Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="burger" items="${burgers}">
						<tr>
							<td>${burger.id }</td>
							<td>${burger.burgerName }</td>
							<td>${burger.restaurantName }</td>
							<td>${burger.rating }</td>
							<td>
								<a class="btn btn-primary" href="/burgers/edit/${burger.id }">Edit</a>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		
		<div>
			<h3 class="mb-5">Add a Burger:</h3>
			
			<form:form action="/burgers" method="post" modelAttribute="burger">
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="burgerName">Burger Name</form:label>					
					<form:input class="col-sm-8" type="text" path="burgerName" />
					<form:errors path="burgerName" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="restaurantName">Restaurant Name</form:label>					
					<form:input class="col-sm-8" type="text" path="restaurantName" />
					<form:errors path="restaurantName" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="rating">Rating</form:label>
					<form:input class="col-sm-8" type="number" path="rating" />
					<form:errors path="rating" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="notes">Notes</form:label>
					<textarea class="col-sm-8" path="notes" rows=4></textarea>
					<form:errors path="notes" class="text-danger"></form:errors>
				</div>
				
				<div class="text-end">
					<input class="btn btn-primary" type="submit" value="Submit" />
				</div>
			
			</form:form>
		</div>
		
	</div>

</body>
</html>
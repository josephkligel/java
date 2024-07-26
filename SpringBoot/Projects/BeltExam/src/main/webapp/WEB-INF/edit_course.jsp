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

<title>Project Manager</title>
</head>
<body>
	<div class="container pt-3">
		
		<form:form action="/classes/update" method="post" modelAttribute="course">
		
				<div class="mb-5">
					<h1>${course.className }</h1>
				</div>
		
				<form:input type="hidden" value="${user.id }" path="user" />
				<form:input type="hidden" value="${course.id }" path="id" />
				<input type="hidden" name="_method" value="put" />
			
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="className">Name:</form:label>					
					<form:input class="col-sm-8" type="text" path="className" />
					<form:errors class="text-danger" path="className"></form:errors>
				</div>
				
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="dayOfWeek">Day of Week:</form:label>
					<form:input class="col-sm-8" type="text" path="dayOfWeek" />
					<form:errors class="text-danger" path="dayOfWeek"></form:errors>
				</div>
				
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="price">Drop-in Price:</form:label>
					<form:input class="col-sm-3" type="number" step="0.01" path="price" />
					<form:errors class="text-danger" path="price"></form:errors>
				</div>
				
				<div class="form-group mb-4 row">
					<form:label class="col-sm-4 col-form-label" path="description">Description:</form:label>
					<form:textarea class="col-sm-8" rows="3" path="description" />
					<form:errors class="text-danger" path="description"></form:errors>
				</div>
			
				<div class="text-end">
					<button class="shadow me-2">Cancel</button>
					<button class="shadow">Edit</button>
				</div>
				
		</form:form>
		
		<form:form action="/classes/delete/${course.id}" method="post"
		class="position-relative"
		>
						<input type="hidden" name="_method" value="delete" />
						<button class="position-absolute shadow bg-danger text-white"
						style="top: -30px;"
						>Delete</button>
		</form:form>
	
	</div>

</body>
</html>
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
<title>Book Club</title>
</head>
<body class="bg-light">

	<div class="container py-3">
	
		<div class="mb-3 d-flex justify-content-between align-items-center">
			<h1>Change your entry</h1>
			<a href="/books">back to the shelves</a>
		</div>
		
		<form:form action="/books/update" method="post" modelAttribute="book">
		
				<input type="hidden" name="_method" value="put" ></input>
				<form:input type="hidden" value="${book.id }" path="id"></form:input>
				<form:input type="hidden" value="${user.id}" path="user" />
			
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="title">Title:</form:label>					
					<form:input class="col-sm-8" type="text" path="title" />
					<form:errors class="text-danger" path="title"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="authorName">Author:</form:label>
					<form:input class="col-sm-8" type="text" path="authorName" />
					<form:errors class="text-danger" path="authorName"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="thoughts">My Thoughts:</form:label>
					<form:textarea rows="3" class="col-sm-8" path="thoughts" />
					<form:errors class="text-danger" path="thoughts"></form:errors>
				</div>
				
				<div class="text-end">
					<input class="btn btn-success" type="submit" value="Update" />
				</div>
		
		</form:form> 
	
	</div>

</body>
</html>
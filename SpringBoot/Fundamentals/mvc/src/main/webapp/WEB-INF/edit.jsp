<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="py-5 w-75 m-auto">
	
		<h1>New Book</h1>
		
		<form:form action="/books/${book.id}" method="post" modelAttribute="book">
		
			<input type="hidden" name="_method" value="put">
		
			<div class="form-group mb-3 row">
				<form:label path="title">Title</form:label>
				<form:errors path="title" class="text-danger" />
				<form:input class="col" type="text" path="title" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="description">Description</form:label>
				<form:errors path="description" class="text-danger" />
				<form:input class="col" type="text" path="description" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="language">Language</form:label>
				<form:errors path="language" class="text-danger" />
				<form:input class="col" type="text" path="language" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="numberOfPages">Pages</form:label>
				<form:errors path="numberOfPages" class="text-danger" />
				<form:input class="col" type="number" path="numberOfPages" />
			</div>
			
			<div>
				<input class="btn btn-primary me-3" type="submit" />
				
			</div>
			
			
			
		
		</form:form>
		
	</div>

</body>
</html>
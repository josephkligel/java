<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

	<div class="container pt-3">
		<div class="d-flex justify-content-between mb-3">
			<h1 class="text-bold">${course.className }</h1>
			<a class="align-self-center" href="/classes">Go Home</a>
		</div>
		
		<h3>Day: ${ course.dayOfWeek}</h3>
		
		<h3 class="mb-3">Cost: ${String.format("$%.2f", course.price) }</h3>
		
		<p>${course.description }</p>
		
		<hr />
	
	</div>

</body>
</html>
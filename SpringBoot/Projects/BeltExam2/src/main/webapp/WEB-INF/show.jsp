<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %><!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Kickball League Dashboard</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container pt-3">
		<div class="mb-3">
			<h1 class="text-bold mb-3">${team.teamName }</h1>
			<a href="/home">dashboard</a>
		</div>
		
		<p>Team Name: ${ team.teamName}</p>
		
		<p>Skill Level: ${team.skillLevel }</p>
		
		<p>Game Day: ${team.gameDay }</p>
		
		<hr />
		
		<c:if test="${team.user.id == user.id }">
		
			<div class="d-flex">
				<a class="me-3" href="/teams/${team.id }/edit">Edit</a>
				
				<form action="/teams/${team.id}/delete" method="post">
					<input type="hidden" name="_method" value="delete" />
					<button class="bg-danger text-white">Delete</button>
				</form>
			</div>
		
		</c:if>
	
	</div>
	
	

</body>
</html>
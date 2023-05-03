<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Dojos and Ninjas</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

		<div class="py-5 w-50 m-auto">
		
			<div class="mb-4">
				<h1>New Dojo</h1>
			</div>
			
			<form:form action="/dojos" method="post" modelAttribute="dojo">
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="location">Location:</form:label>					
					<form:input class="col-sm-8" type="text" path="location" />
					<form:errors path="location" class="text-danger" />
				</div>
				
				
				<div class="text-end">
					<input class="bg-primary text-white" type="submit" value="Create" />
				</div>
			
			</form:form>
		</div>

</body>
</html>
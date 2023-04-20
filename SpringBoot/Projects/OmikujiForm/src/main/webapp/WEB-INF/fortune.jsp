<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikugi Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS --> 
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="py-3 w-75 m-auto">
		<h3 class="text-center mb-3">Here's Your Omikuji!</h3>
		
		<div class="p-4 border border-dark border-2 bg-primary text-white mb-5">
			<p class="fs-3">
				In <c:out value="${formData.number[0]}" /> years, 
				you will live in <c:out value="${formData.city[0] }" /> 
				with <c:out value="${formData.person[0] }" /> as your room mate, 
				selling <c:out value="${formData.interest[0] }" /> for a living. 
				The next time you see a <c:out value="${formData.thing[0] }" />, you will have good luck. 
				Also, <c:out value="${formData.comment[0] }" />
			</p>
			
		</div>
		
		<div class="text-center">
			<a href="/okumiji">Go Back</a>
		</div>
	</div>

</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save Travels</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="py-5 w-50 m-auto">
	
			<div class="d-flex justify-content-between mb-4">
				<h1 class="text-success">Expense Details</h1>
				<a class="align-self-center" href="/expenses">Go Back</a>
			</div>
			
		<div>
				<div class="form-group row mb-2">
					<label class="col-sm-4">Expense Name:</label>
					<p class="col-sm-8">${expense.expenseName }</p>
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-4">Expense Description:</label>					
					<p class="col-sm-8">${expense.description }</p>
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-4">Vendor:</label>
					<p class="col-sm-8">${expense.vendor }</p>
				</div>
				
				<div class="form-group mb-2 row">
					<label class="col-sm-4">Amount:</label>
					<p class="col-sm-8">
						<c:out value="${String.format('$%.2f', expense.amount)}" />
					</p>
				</div>
		</div>
		
	</div>

</body>
</html>
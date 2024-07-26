<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>

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
	<div class="py-3">
	
		<div class="mb-5 w-75 m-auto">
		
			<h1 class="text-primary mb-4">Save Travels</h1>
			
			<table class="table table-striped text-center">
				<thead class="table-secondary">
					<tr>
						<th>Expense Name</th>
						<th>Vendor</th>
						<th>Amount</th>
						<th class="text-start">Actions</th>
					</tr>
				</thead>
				
				<tbody>
					<c:forEach var="expense" items="${expenses}">
						<tr>
							<td>
								<a href="/expenses/${expense.id}">
									${expense.expenseName }
								</a>
							</td>
							<td>${expense.vendor }</td>
							<td>${String.format("$%.2f", expense.amount) }</td>
							<td class="d-flex align-items-end">
								<a href="/expenses/edit/${expense.id }">edit</a>
								<form action="/expenses/${expense.id}" method="post">
								    <input type="hidden" name="_method" value="delete">
								    <input class="bg-danger text-white ms-3" type="submit" value="Delete">
								</form>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
		</div>
		
		<div class="w-50 m-auto">
		
			<h2 class="text-primary mb-4">Add an Expense:</h2>
			
			<form:form action="/expenses" method="post" modelAttribute="expense">
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="expenseName">Expense Name:</form:label>					
					<form:input class="col-sm-8" type="text" path="expenseName" />
					<form:errors path="expenseName" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="vendor">Vendor:</form:label>					
					<form:input class="col-sm-8" type="text" path="vendor" />
					<form:errors path="vendor" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="amount">Amount:</form:label>
					<form:input class="col-sm-8" type="number" step="0.01" path="amount" />
					<form:errors path="amount" class="text-danger"></form:errors>
				</div>
				
				<div class="form-group mb-3 row">
					<form:label class="col-sm-4 col-form-label" path="description">Description:</form:label>
					<form:textarea class="col-sm-8" path="description"></form:textarea>
					<form:errors path="description" class="text-danger"></form:errors>
				</div>
				
				<div class="text-end">
					<input class="bg-primary text-white" type="submit" value="Submit" />
				</div>
			
			</form:form>
		</div>
	
	</div>

</body>
</html>
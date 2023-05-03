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
				<h1>New Ninja</h1>
			</div>
			
			<form:form action="/ninjas" method="post" modelAttribute="ninja">
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="dojo">Dojo:</form:label>					
					<form:select class="col-sm-8" type="text" path="dojo">
							<c:forEach var="oneDojo" items="${dojos }">
								
								<form:option itemLabel="dojo_id" value="${oneDojo }">
									<c:out value="${oneDojo.location }" />
								</form:option>
							
							</c:forEach>
					</form:select>
					<form:errors path="dojo" class="text-danger"></form:errors>
				</div>
			
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="firstName">First Name:</form:label>					
					<form:input class="col-sm-8" type="text" path="firstName" />
					<form:errors path="firstName" class="text-danger" />
				</div>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="lastName">Last Name:</form:label>					
					<form:input class="col-sm-8" type="text" path="LastName" />
					<form:errors path="lastName" class="text-danger" />
				</div>
				
				<div class="form-group row mb-3">
					<form:label class="col-sm-4 col-form-label" path="age">Age:</form:label>					
					<form:input class="col-sm-8" type="number" path="age" />
					<form:errors path="age" class="text-danger" />
				</div>
				
				
				<div class="text-end">
					<input class="bg-primary text-white" type="submit" value="Create" />
				</div>
			
			</form:form>
		</div>

</body>
</html>
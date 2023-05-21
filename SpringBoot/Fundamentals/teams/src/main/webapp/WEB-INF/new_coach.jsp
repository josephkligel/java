<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

		<div class="py-5 w-75 m-auto">
	
		<h1>New Coach</h1>
		
		<form:form action="/coach" method="post" modelAttribute="coach">
		
			<div class="form-group mb-3 row">
				<form:label path="firstName">First Name:</form:label>
				<form:errors path="firstName" class="text-danger" />
				<form:input class="col" type="text" path="firstName" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="lastName">Last Name:</form:label>
				<form:errors path="lastName" class="text-danger" />
				<form:input class="col" type="text" path="lastName" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="age">Age</form:label>
				<form:errors path="age" class="text-danger" />
				<form:input class="col" type="number" path="age" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="role">Role:</form:label>
				<form:errors path="role" class="text-danger" />
				<form:input class="col" type="text" path="role" />
			</div>
			
			<div class="form-group mb-3 row">
				<form:label path="team">Team:</form:label>
				<form:errors path="team" class="text-danger" />
				<form:select path="team">
					<c:forEach var="team" items="${teams }">
						<form:option itemLabel="team_id" value="team">
							<c:out value="${team.name }" />
						</form:option>
					</c:forEach>
				</form:select>
			</div>
			
			<div>
				<input class="btn btn-primary" type="submit" />
			</div>
		
		</form:form>
		
	</div>
	

</body>
</html>
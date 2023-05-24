<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
			<h1>${user.username }.</h1>
			<a class="align-self-center" href="/logout">Logout</a>
		</div>
		
		<p>Course Schedule</p>
		
		<table class="table table-bordered table-striped mb-5">
			<thead class="bg-light">
				<th>Class Name</th>
				<th>Instructor</th>
				<th>Weekday</th>
				<th>Price</th>
			</thead>
			<tbody>
				<c:forEach var="course" items="${courses }">
					<tr>
						<td>
							<a class="me-2" href="/classes/${course.id }">
								${course.className }
							</a>
								<c:if test="${user.id == course.user.id }">
									<button class="shadow">
										<a class="text-decoration-none text-dark" href="/classes/${course.id }/edit">
											edit
										</a>
									</button>
								</c:if>
						</td>
						<td>${course.user.username }</td>
						<td>${course.dayOfWeek }</td>
						<td>${course.price }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	
		<div>
			<button class="shadow">
				<a class="text-decoration-none text-dark" href="/classes/new">
					+ new course
				</a>
			</button>
			
		</div>
		
	</div>

</body>
</html>
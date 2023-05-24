<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
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
	
		<div class="mb-4">
			<h1>Welcome ${user.userName }!</h1>
			<a class="align-self-center" href="/logout">Logout</a>
		</div>
		
		
		<div>
		
			<table class="table table-striped table-bordered mb-4">
				<thead style="background-color: lightgrey;">
					<th>Team Name</th>
					<th>Skill Level (1-5)</th>
					<th>Game Day</th>
				</thead>
				<tbody>
					<c:forEach var="team" items="${teams }">
						<tr>
							<td>
								<a href="/teams/${team.id }">
									${team.teamName }
								</a>
							</td>
							<td>${team.skillLevel }</td>
							<td>${team.gameDay }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			
			<a class="btn btn-outline-dark w-100" href="/teams/new">
				Create New Team
			</a>
		
		</div>
		
	
	</div>

</body>
</html>
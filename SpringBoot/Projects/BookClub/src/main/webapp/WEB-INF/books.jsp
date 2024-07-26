<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Book Club</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>

	<div class="container py-3">
	
		<div class="d-flex justify-content-between align-items-center">
			<h1>Welcome ${user.userName }!</h1>
			<a href="/logout">Logout</a>
		</div>
		
		<div class="d-flex justify-content-between">
			<p>Books from everyone's shelves:</p>
			<a href="/books/new">+ Add a book to my shelf</a>
		</div>
		
		<table class="table table-striped">
			<thead>
				<th>ID</th>
				<th>Title</th>
				<th>Author Name</th>
				<th>Posted By</th>
			</thead>
			<tbody>
				<c:forEach var="book" items="${books }">
					<tr>
						<td>
							${book.id }
						</td>
						<td><a href="/books/${book.id }">${book.title }</a></td>
						<td>${book.authorName }</td>
						<td>${book.user.getUserName() }</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		
	</div>

</body>
</html>
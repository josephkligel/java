<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="my-5 w-50 m-auto card">
		<h3 class="card-header">${book.title }</h3>
		<div class="card-body">
			<p>Description: ${book.description }</p>
			<p>Language: ${book.language }</p>
			<p>Number of Pages: ${book.numberOfPages }</p>
		</div>
		
		<form action="/books/${book.id}" method="post">
		    <input type="hidden" name="_method" value="delete">
		    <input class="btn btn-danger ms-3 mb-3" type="submit" value="Delete">
		</form>
		
	</div>

</body>
</html>
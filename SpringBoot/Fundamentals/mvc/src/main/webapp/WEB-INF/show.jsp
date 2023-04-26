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

	<div class="p-5">
		<h3><c:out value="${book.title}" /></h3>
		<p>Description <c:out value="${book.description }" /></p>
		<p>Language: <c:out value="${book.language }" /></p>
		<p>Number of Pages: <c:out value="${book.numberOfPages}" /></p>
		
	</div>

</body>
</html>
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
	
		<h1>New Book</h1>
		
		<form>
		
			<div class="form-group mb-3 row">
				<label class="col">Title</label>
				<input class="col" type="text" />
			</div>
			
			<div class="form-group mb-3 row">
				<label>Description</label>
				<input class="col" type="text" />
			</div>
			
			<div class="form-group mb-3 row">
				<label>Language</label>
				<input class="col" type="text" />
			</div>
			
			<div class="form-group mb-3 row">
				<label>Pages</label>
				<input class="col" type="number" />
			</div>
			
			<div>
				<input type="submit" />
			</div>
		
		</form>
	</div>

</body>
</html>
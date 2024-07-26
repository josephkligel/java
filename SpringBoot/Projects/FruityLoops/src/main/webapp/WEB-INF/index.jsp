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

	<div class="px-5 py-3">
		<h1 class="text-success mb-3">Fruit Store</h1>
		
		<table class="table table-bordered table-striped shadow rounded">
		
			<thead class="bg-success bg-gradient text-white">
				<tr>
					<th>Name</th>
					<th>Price</th>
				</tr>
			</thead>
			
			<tbody>
			
				<c:forEach var="fruit" items="${fruits}">
					<tr>
						<td><c:out value="${fruit.getName()}" /></td>
						
						<td><c:out value="${fruit.getPrice()}"></c:out></td>
					</tr>	
				</c:forEach>
			
			</tbody>
		
		</table>
	</div>

</body>
</html>
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
			<h1>${book.title }</h1>
			<a href="/books">back to the shelves</a>
		</div>
		
		<div>
			<p>
				<strong>
					<span class="text-danger">
						${ book.user.id == loggedinUser.id ? 'You' : book.user.userName }
					</span> 
					read 
					<span style="color: rebeccapurple">
						${book.title }
					</span>
					by 
					<span class="text-success">
						${book.authorName }
					</span>.
				</strong>
			</p>
			
			<div>
				<p>Here are ${ book.user.id == loggedinUser.id ? 'your': String.format("%s's", book.user.userName)} thoughts:</p>
				<div class="ms-5 w-75">
					<hr />
					<small>
						
						${book.thoughts }
					</small>
					<hr />
				</div>
			</div>
			
			<c:if test="${book.user.id == loggedinUser.id }">
			
				<div class="d-flex justify-content-center">
					<a href="/books/edit/${book.id }" class="btn btn-success me-3">edit</a>
					
					<form action="/books/delete/${book.id }" method="post">
						<input type="hidden" name="_method" value="delete" />
						<button class="btn btn-danger">
							delete
						</button>
					</form>
				</div>
				
			</c:if>
			
		</div>
		
	</div>

</body>
</html>
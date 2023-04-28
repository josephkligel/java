<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   

<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS -->
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
 
 <div class="py-5 w-75 m-auto">
	<h1>All Books</h1>
	<table class="table">
	    <thead class="table-dark">
	        <tr>
	            <th>ID</th>
	            <th>Title</th>
	            <th>Language</th>
	            <th>Number of Pages</th>
	        </tr>
	    </thead>
	    <tbody>
	         <c:forEach items="${books }" var="book">
	         	<tr>
	         		<td>${book.id}</td>
	         		<td>
	         			<a href="/books/${book.id}">
	         				${book.title}
	         			</a>
	         		</td>
	         		<td>${book.language }</td>
	         		<td>${book.numberOfPages }</td>
	         	</tr>
	         </c:forEach>
	    </tbody>
	</table>
 
 </div>

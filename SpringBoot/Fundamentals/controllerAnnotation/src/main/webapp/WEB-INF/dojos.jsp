<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8" />
    <title>Dojo Page</title>
</head>
<body>
    <h1>Dojo Locations</h1>
    <c:forEach var="oneDojo" items="${dojosFromController}">
    	<p><c:out value="${oneDojo}" /></p>
    </c:forEach>
</body>
</html>

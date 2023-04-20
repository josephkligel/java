<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Omikugi Form</title>
<!-- for Bootstrap CSS -->
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css" />
<!-- YOUR own local CSS --> 
<link rel="stylesheet" href="/css/main.css"/>
<!-- For any Bootstrap that uses JS -->
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>

</head>
<body>

	<div class="py-3 w-75 m-auto">
	
	<h3 class="text-center mb-3">Send an Okumiji!</h3>
	<form class="border border-dark border-2 px-5 py-3 rounded" action="/formData" method="post">
		<div class="form-group row mb-3">
			<label class="form-label">Pick any number from 5 to 25:</label>
			<input class="col-2" type="number" name="number"/>
		</div>
		
		<div class="form-group row mb-3">
			<label class="form-label">Enter the name of any city:</label>
			<input class="col-8" type="text" name="city" />
		</div>
		
		<div class="form-group row mb-3">
			<label class="form-label">Enter the name of any real person:</label>
			<input class="col-8" type="text" name="person" />
		</div>
		
		<div class="form-group row mb-3">
			<label class="form-label">Enter professional endeavor or hobby:</label>
			<input class="col-8" type="text" name="interest"/>
		</div>
		
		<div class="form-group row mb-3">
			<label class="form-label">Enter any type of living thing</label>
			<input class="col-8" type="text" name="thing" />
		</div>
		
		<div class="form-group row mb-3">
			<label class="form-label">Say something nice to someone:</label>
			<textarea class="col-10" name="comment">
			
			</textarea>
		</div>
		
		<p>Send and show a friend</p>
		
		<div class="text-end col-10">
			<input type="submit" class="btn btn-primary" />
		</div>
	</form>
	
	</div>


</body>
</html>
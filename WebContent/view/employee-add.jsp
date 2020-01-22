<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Edit Employee</title>
</head>
<link href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css" rel="stylesheet"/>
<body>
<div class="container">
	<p>${message}</p>
	<h3>Edit Employee</h3>
	<form action="${pageContext.request.contextPath}/EmployeeController" method="POST">
	 	<div class="form-group">
			<input type="text" name="name" placeholder="Enter name" value="${employee.name}" class="form-control"/>
		</div>
		 <div class="form-group">
			<input type="date" name="dob" value="${employee.dob}" class="form-control"/>
		</div>
		 <div class="form-group">
			<input type="text" name="designation" value="${employee.departament}" placeholder="Enter designation" class="form-control"/>
		</div>
		 <div class="form-group">
			<input type="hidden" name="id" value="${employee.id}" class="form-control"/>
		</div>
		
		<button class="btn btn-primary" type="submit">Save Employee</button>
	</form>
</div>
</body>
</html>
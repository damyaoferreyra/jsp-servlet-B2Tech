<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employee</title>
</head>

<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />

<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.css" />

<body>
	<div class="container">
		<div class="row justify-content-md-end">
			<a href='${pageContext.request.contextPath}/logout.jsp'">Logout</a>
		</div>

		<div class="row">
			<div class="col m8">
				<h3>Employees</h3>
			</div>
			<div class="col m4 justify-content-end">
				<button class="btn btn-primary"
					onclick="window.location.href='view/employee-add.jsp'">Add
					Employee</button>
			</div>
		</div>
		<table class="table table-striped table-bordered" id="employeeTable">
			<thead class="thead-dark">
				<tr>
					<th>Name</th>
					<th>Department</th>
					<th>Data of birthday</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${list}" var="employee">
					<tr>
						<td>${employee.name}</td>
						<td>${employee.departament}</td>
						<td>${employee.dob}</td>
						<td><a
							href="${pageContext.request.contextPath}/EmployeeController?action=EDIT&id=${employee.id}"
							class="btn btn-primary">EDIT</a> | <a
							href="${pageContext.request.contextPath}/EmployeeController?action=DELETE&id=${employee.id}"
							class="btn btn-warning">DELETE</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
<script src="https://unpkg.com/jquery@3.3.1/dist/jquery.min.js"></script>
<script type="text/javascript"
	src="https://cdn.datatables.net/v/dt/dt-1.10.20/datatables.min.js"></script>
<script>
	$(document).ready(function() {
		$('#employeeTable').DataTable();
	});
</script>

<%
	request.removeAttribute("id");
%>
</html>
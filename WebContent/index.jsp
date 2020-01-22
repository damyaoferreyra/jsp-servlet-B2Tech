<html>
<head>
<title>Employee - Login</title>
</head>
<link
	href="https://unpkg.com/bootstrap@4.3.1/dist/css/bootstrap.min.css"
	rel="stylesheet" />
<body>
	<%
		String email = (String)session.getAttribute("email");

		if (email != null)
			response.sendRedirect("EmployeeController?action=LIST");

		String status = request.getParameter("status");

		if (status != null) {

			if (status.equals("false"))
				out.print("Bad credentials");
			else if (status.equals("error"))
				out.print("Some error occured");

		}
	%>

	<div class="container-fluid h-100">
		<div class="row justify-content-center align-items-center h-100">
			<div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
				<form action="loginProcess" method="post">
					<div class="form-group">
						<input class="form-control form-control-lg"
							placeholder="Enter e-mail" type="text" name="email">
					</div>
					<div class="form-group">
						<input class="form-control form-control-lg"
							placeholder="Enter password" type="password" name="password">
					</div>
					<div class="form-group">
						<button class="btn btn-info btn-lg btn-block" type="submit">LOGAR</button>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
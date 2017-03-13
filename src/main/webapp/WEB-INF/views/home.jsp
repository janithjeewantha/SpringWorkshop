<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Student Registration</title>
	<link rel="stylesheet" 
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<style>
		.table > tbody > tr > td, .table > tbody > tr > th, .table > tfoot > tr > td, .table > tfoot > tr > th, .table > thead > tr > td, .table > thead > tr > th {
	    	border-top: none;
		}
	</style>
</head>
<body>
<h1>
	&nbsp&nbspWelcome to the VLE!  
</h1>
<br/>
<div class="container">
	<c:if test="${signUpProcess}">
		<c:if test="${signUpSuccess}">
			<div>
				<div class="alert alert-success">
					<strong>Success!</strong> You can now Log In
				</div>
			</div>
		</c:if>
		<c:if test="${not signUpSuccess}">
			<div>
				<div class="alert alert-danger">
					<strong>Error!</strong> Please check the details again. Are you already registered?
				</div>
			</div>
		</c:if>
	</c:if>
	<c:if test="${logInProcess}">
		<c:if test="${not loginSuccess}">
			<div>
				<div class="alert alert-danger">
					<strong>Login Failed!</strong> Please check the details again
				</div>
			</div>
		</c:if>
	</c:if>
	<div class="row">
		<div id="loginform" class="col-md-2" style="width:25%">
			<h3>Log In</h3>
			<form method="post" action="login">
				<table class="table borderless">
					<tr>
						<td>Username:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="pass" /><br/></td>
					</tr>
					<tr>
						<td><input type="submit" value="login" /></td>
					</tr>		
				</table>
			</form>
		</div>
		<div style="width:20%" class="col-md-2"></div>
		<div id="signupform" class="col-md-2" style="width:25%">	
			<h3>Sign Up</h3>
			<form method="post" action="">
				<table class="table borderless">
					<tr>
						<td>Username:</td>
						<td><input type="text" name="username" /></td>
					</tr>
					<tr>
						<td>Email:</td>
						<td><input type="text" name="email" /></td>
					</tr>
					<tr>
						<td>Password:</td>
						<td><input type="text" name="pass" /></td>
					</tr>
					<tr>
						<td><input type="submit" value="register" /></td>
					</tr>		
				</table>			
			</form>
		</div>
	</div>
</div>
</body>
</html>

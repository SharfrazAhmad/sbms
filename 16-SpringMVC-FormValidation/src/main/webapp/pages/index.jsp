<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>User registration form</h1>
	<form:form action="register" modelAttribute="user" method="POST">
		<table>
			<tr>
				<td>User name</td>
				<td><form:input path="uname" /> <form:errors path="uname" /></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><form:input path="pwd" /></td>
			</tr>
			<tr>
				<td>Email:</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone no.:</td>
				<td><form:input path="phno" /></td>
			</tr>
			<tr>
				<td>Age:</td>
				<td><form:input path="age" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>


	</form:form>

</body>
</html>
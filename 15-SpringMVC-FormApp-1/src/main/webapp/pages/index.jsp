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
	<form:form action="product" modelAttribute="product" method="POST">
		<table>
			<tr>
				<td>Product ID</td>
				<td><form:input path="productId" /></td>
			</tr>

			<tr>
				<td>Product name</td>
				<td><form:input path="productName" /></td>
			</tr>

			<tr>
				<td>Product price</td>
				<td><form:input path="productPrice" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Submit"></td>
			</tr>
		</table>
	</form:form>
</body>
</html>
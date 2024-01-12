<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	<h2>List Users</h2>

	<table border="1">
		<tr>
			<th>UserId</th>
			<th>FirstName</th>
			<th>Action</th>
		</tr>
		<c:forEach items="${users}" var="u">
			<tr>
				<td>${u.userId }</td>
				<td>${u.firstName}</td>
				<td><a href="deleteuser?userId=${u.userId}">Delete</a>
					|
					<a href="viewuser?userId=${u.userId}">View</a>
				</td>
			</tr>
		</c:forEach>


	</table>


</body>
</html>
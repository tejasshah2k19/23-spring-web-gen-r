<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  %>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Signup</h2>
	<s:form action="saveuser" method="post" modelAttribute="user">
		FirstName: 
		<s:input path="firstName" />
		<s:errors path="firstName"></s:errors>
		<br>
		<br> 
		Email:<s:input path="email" />
		<s:errors path="email"></s:errors>


		<br>
		<br> 
		Password:  <s:password path="password" />
		<s:errors path="password"></s:errors>

		<br>
		<br>
		<input type="Submit" value="Signup" />
	</s:form>
</body>
</html>
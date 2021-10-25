<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>luv2code Company Home Page</title>
</head>
<body>

	<h2>luv2code Company Home Page</h2>

	<hr>

	<p>Welcome to the luv2code company home page!</p>

	<!-- Add logout button to the form -->
	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="Logout" />
	</form:form>
</body>
</html>
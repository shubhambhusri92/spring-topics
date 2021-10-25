<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<title>Student Confirmation Form</title>
</head>
<body>
	<%-- here the spring will call getFirstName() and getLastName() for ${student.FirstName} and ${student.LastName} --%>
	The student is confirmed: ${student.firstName} ${student.lastName}

	<br>
	<br> Country: ${student.country}
	<%--  spring will call student.getCountry --%>

	<br>
	<br> Favorite Language: ${student.favoriteLanguage}
	<%--  spring will call student.getFavoriteLanguage() --%>

	<br>
	<br>
	
	Operating Systems : 
	<ul>
		<c:forEach var="temp" items="${student.operatingSystem}">
			<li>${temp}</li>
		</c:forEach>

	</ul>	

</body>
</html>
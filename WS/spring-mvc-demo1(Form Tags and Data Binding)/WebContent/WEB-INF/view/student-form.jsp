<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>

<html>

<head>
<title>Student Registration Form</title>
</head>


<body>
	<form:form action="processForm" modelAttribute="student">
       First name: <form:input path="firstName" />
		<br>
		<br>
       
       Last name: <form:input path="lastName" />
		<br>
		<br>
       
       Country :
       
       <%--here spring calls student.setCountry basically which is on the path name it will cal setter for that property--%>
		<form:select path="country">


			<%--
			    here populating from hardcode
			    but in lower scenario it's populating from code
			  <form:option value="Brazil" label="Brazil"/>
			<form:option value="France" label="France"/>
			<form:option value="Germany" label="Germany"/>
			<form:option value="India" label="India"/> --%>


			<%-- items refer to collection of data  spring call student.countryOptions  --%>
			<form:options items="${student.countryOptions}" />

		</form:select>
		<br>
		<br>
		
		Favorite Language : 
		<%-- spring calls student.setFavoritelanguage --%>
		Java <form:radiobutton path="favoriteLanguage" value="Java" />
		C# <form:radiobutton path="favoriteLanguage" value="C#" />
		Ruby <form:radiobutton path="favoriteLanguage" value="Ruby" />
	    .Net <form:radiobutton path="favoriteLanguage" value=".Net" />

		<br>
		<br>
		
		Operating System : 
		
		Linux<form:checkbox path="operatingSystem" value="Linux" />
		Mac Os<form:checkbox path="operatingSystem" value="Mac OS" />
		MS Windows<form:checkbox path="operatingSystem" value="MS Windows" />



		<input type="submit" value="Submit" />
	</form:form>
</body>

</html>
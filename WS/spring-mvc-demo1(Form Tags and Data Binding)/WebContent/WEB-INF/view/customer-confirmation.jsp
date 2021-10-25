<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>

<title>Customer Confirmation Form</title>
</head>
<body>
	<%-- here the spring will call getFirstName() and getLastName() for ${customer.FirstName} and ${customer.LastName} --%>
	The student is confirmed: ${customer.firstName} ${customer.lastName}
	<br><br>
	Free Passes are : ${customer.freePasses}
	<br><br>
	Postal Code : ${customer.postalCode}
	<br><br>
	Course Code : ${customer.courseCode}

</body>
</html>
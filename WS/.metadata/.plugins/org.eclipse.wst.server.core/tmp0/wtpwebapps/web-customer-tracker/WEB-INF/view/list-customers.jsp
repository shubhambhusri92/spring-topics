<!--  Add support for JSTL core tags -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>


<title>List Customers</title>

<!--  reference our css style sheet -->
<!--  pageContext.request.contextPath} will provide proper app name -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>

	<!--  div is a container for html element -->
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer RelationShip Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">

			<!--  Add a new button for adding customer -->
			<!--  here it call our  spring controller showFormForAdd -->
			<input type="button" value="Add Customer"
				onclick="window.location.href='showFormForAdd'; return false;"
				class="add-button" />
			<!--  add-button is css style sheet -->
			<!--  Add out html table here -->
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>

				<!--  loop over and print customers -->
				<c:forEach var="tempCustomer" items="${customers}">

					<!--  construct  an "update" link with customer id -->

					<c:url var="updateLink" value="/customer/showFormForUpdate">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="customerId" value="${tempCustomer.id}"></c:param>
					</c:url>

					<tr>
						<td>${tempCustomer.firstName}</td>
						<!--  here we have used jsp expression spring will call tempCustomer.getFirstName() -->
						<td>${tempCustomer.lastName}</td>
						<td>${tempCustomer.email}</td>
						<td>
							<!--  display the updated link --> <a href="${updateLink}">Update</a>

							<!--  display the delete  link and add javascript to promp --> <a
							href="${deleteLink}"
							onclick="if(!(confirm('Are you sure you want to delete this customer?'))) return false">Delete</a>
						</td>

					</tr>

				</c:forEach>
			</table>


		</div>
	</div>

</body>
</html>
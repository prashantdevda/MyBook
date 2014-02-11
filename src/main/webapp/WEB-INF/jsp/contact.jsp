<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>Spring 3 mvc series - ContactManager | prashantdevda.net</title>
<link href="css/main.css" rel="stylesheet" type=""text/css>
</head>
<body>
	<h2>Contact Manager</h2>
	<form:form method="post" action="add" commandName="contact">
		<table>
			<tr>
				<td><form:label path="firstname">
						<spring:message code="label.firstname" />
					</form:label></td>
				<td><form:input path="firstname" /></td>
			</tr>
			<tr>
				<td><form:label path="lastname">
						<spring:message code="label.lastname" />
					</form:label></td>
				<td><form:input path="lastname" /></td>
			</tr>
			<tr>
				<td><form:label path="email">
						<spring:message code="label.email" />
					</form:label></td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td><form:label path="telephone">
						<spring:message code="label.telephone" />
					</form:label></td>
				<td><form:input path="telephone" /></td>
			</tr>
			<tr>
				<td><form:label path="address">
						<spring:message code="label.address" />
					</form:label></td>
				<td><form:input path="address" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit"
					value="<spring:message code="label.addcontact"/>"></td>
			</tr>
		</table>
	</form:form>

	<h3>Contact</h3>
	<c:if test="${!empty contactList}">
		<table border="1" class="result">
			<tr id="t_heading">
				<th>Name</th>
				<th>Email</th>
				<th>Telephone</th>
				<th>Address</th>
				<th>&nbsp;</th>
				<th>&nbsp;</th>
			</tr>
			<c:forEach items="${contactList}" var="contact">
				<tr>
					<td>${contact.lastname}, ${contact.firstname}</td>
					<td>${contact.email}</td>
					<td>${contact.telephone}</td>
					<td>${contact.address}</td>
					<td><a href="delete/${contact.id}">delete</a></td>
					<td><a href="edit/${contact.id}">edit</a></td>
				</tr>
			</c:forEach>
		</table>
	</c:if>
</body>
</html>
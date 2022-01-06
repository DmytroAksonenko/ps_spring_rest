<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>

<body>
	<h2>Book Info</h2>
	<br>

	<form:form action="saveBook" modelAttribute="book">
		
		<form:hidden path="id"/>
	
		Name <form:input path="name" />
		<br>
		<br>
		Author <form:input path="author" />
		<br>
		<br>
		Genre <form:input path="genre" />
		<br>
		<br>
		Price <form:input path="price" />
		<br>
		<br>
		<input type="submit" value="Accept">

	</form:form>

</body>

<body>

</body>
</html>
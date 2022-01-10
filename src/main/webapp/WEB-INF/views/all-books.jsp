<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page isELIgnored="false"%>

<!DOCTYPE html>
<html>

<body>

	<h2>Library</h2>
	<br>

	<table>
		<tr>
			<th>Name</th>
			<th>Author</th>
			<th>Genre</th>
			<th>Price</th>
			<th>Operations</th>
		</tr>

		<c:forEach var="book" items="${allBooks}">
		
			<c:url var="updateButton" value="/updateInfo">
				<c:param name="bookId" value="${book.id}" />
			</c:url>

			<tr>
				<td>${book.name}</td>
				
				<c:forEach var="author" items="${allAuthors}">
				
					<c:if test="${author.id == book.author}">
						<td>&nbsp; ${author.name} &nbsp;${author.surname}</td>
					</c:if>
					
				</c:forEach>
				
				<td>&nbsp;${book.genre}&nbsp;</td>
				
				<td>&nbsp;${book.price}</td>
				
				<td>
					<input type="button" value="UPDATE"
						onClick="window.location.href = '${updateButton}'" />
				</td>
					
				<td>
					<form:form method="POST" action="deleteBook"
						modelAttribute="book.id">
						<input type="hidden" name="book.id" value="${book.id}" />
						<input type="hidden" name="_method" value="DELETE" />
						<input type="submit" value="DELETE">
					</form:form>
				</td>
			</tr>

		</c:forEach>

	</table>

	<br>

	<input type="button" value="Add a new book to the library"
		onclick="window.location.href = 'addNewBook'" />

</body>

</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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

			<c:url var="deleteButton" value="/deleteBook">
				<c:param name="bookId" value="${book.id}" />
			</c:url>

			<tr>
				<td>${book.name}</td>
				<td>&nbsp;${book.author}</td>
				<td>&nbsp;${book.genre}&nbsp;</td>
				<td>&nbsp;${book.price}</td>
				<td>
					<input type="button" value="Update"
					onClick="window.location.href = '${updateButton}'" /> 
					<input type="button" value="Delete"
					onClick="window.location.href = '${deleteButton}'" />
				</td>
			</tr>
		</c:forEach>

	</table>

	<br>

	<input type="button" value="Add a new book to the library"
		onclick="window.location.href = 'addNewBook'" />

</body>

</html>
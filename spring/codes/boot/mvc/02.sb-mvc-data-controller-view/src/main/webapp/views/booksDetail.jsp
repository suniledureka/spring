<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" integrity="sha384-rbsA2VBKQhggwzxH7pPCaAqO46MgnOM80zW1RWuH61DGLwZJEdK2Kadq2F9CUG65" crossorigin="anonymous">
<title>Book Details</title>
</head>
<body>
	<table class="table w-50 m-5 table-striped">
		<thead class="thead-dark bg-warning">
			<tr>
				<th>Book ID</th>
				<th>Book Title</th>
				<th>Book Price</th>
			</tr>
		</thead>

		<tbody>
			<c:forEach items="${books}" var="book">
				<tr>
					<td>${book.bookId}</td>
					<td>${book.bookTitle}</td>
					<td>${book.bookPrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.min.js" integrity="sha384-cuYeSxntonz0PPNlHhBs68uyIAVpIIOZZ5JqeqvYYIcEL727kskC66kF92t6Xl2V" crossorigin="anonymous"></script>	
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	p, a{
	 font-size:22px;
	}
</style>
<title>Product Details</title>
</head>
<body>
	<h2 style="text-align:center">${message}</h2>
	<p>
	  	Product ID: ${pid}
	</p>
	<p>
		Product Name: ${pname}
	</p>
	<p>
		Product Price: ${pprice}
	</p>
	<br><br><br>
	<a href="entryform">Next Product</a>
</body>
</html>
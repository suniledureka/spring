<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
	table{
		width:450px;
		box-shadow:0 0 10px black;
		border-collapse:collapse;
		font-size:20px;
		margin:100px auto;
	}
	td{
		border:1px solid black;
	}
	tr{
		height: 45px;
	}
	input{
		font-size:18px;
	}
</style>
<title>Product Entry</title>
</head>
<body>
	<form:form action="saveproduct" method="post" modelAttribute="product">
		<table>
			<tr>
			  <td>Product ID</td>
			  <td><form:input path="productId" size="22" />
			</tr>
			
			<tr>
			  <td>Product Name</td>
			  <td><form:input path="productName" size="22" />
			</tr>			
			
			<tr>
			  <td>Product Price</td>
			  <td><form:input path="productPrice" size="22" />
			</tr>			
			
			<tr style="text-align:center">
			  <td><input type=submit value="Save Product"></td>
			  <td><input type="reset" value="Clear"></td>
			</tr>			
		</table>
	</form:form>
</body>
</html>
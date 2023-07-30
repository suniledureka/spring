<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
 h1{
   text-align:center;
 }
 table{
  width:550px;
  font-size:20px;
  margin:100px auto;
  border-collapse:collapse;
 }
 th, td{
  border:1px solid black;
 }
 tr{
   height:45px;
 }
 p{
  text-align:center;
  font-size:20px;
  color:red;
 }
 table
</style>
<title>edureka :: library</title>
</head>
<body>	
	<p>${error_msg}</p>
	<table>
	 <caption>EDUREKA :: LIBRARY :: BOOK DETAILS</caption>
	 <tr>
	   <th width="25%">BOOK ID</th>
	   <td>${book.bookId}</td>
	 </tr>
	 <tr>
	   <th>TITLE</th>
	   <td>${book.bookTitle}</td>
	 </tr>	 
	 <tr>
	   <th>PRICE</th>
	   <td>${book.bookPrice}</td>
	 </tr>	 
	</table>
</body>
</html>
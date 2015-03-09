<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Magic Printing Clothing</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="section">
<h1>Customer Order History</h1>
<table>
<caption>Orders</caption>
<tr>
	<th>Order Id</th>
	<th>Total</th>
	<th>Status</th>
	<th>payment</th>
	<th>Feedback</th>	
</tr>
<tr>
	<td>P001</td>
	<td>160</td>
	<td>Processing</td>
	<td>payment</td>
	<td>Feedback</td>
</tr>
</table>
<table>
<tr>
	<th>Item Name</th>
	<th>Item Units</th>
	<th>Price Per Unit</th>
	<th>Total Price</th>
</tr>
<tr>
	<td>T-Shirt</td>
	<td>2</td>
	<td>20</td>
	<td>40</td>
</tr>
<tr>
	<td>Pants</td>
	<td>3</td>
	<td>10</td>
	<td>30</td>
</tr>
</table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
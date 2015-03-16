<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Magic Printing Clothing</title>
<link rel="stylesheet"
	href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
	<jsp:include page="/WEB-INF/views/header.jsp" />
	
	<div id="section">
		<div id="customerOrder">
			<form action="createCustomerOrder">
			<input type="submit" value="Create Order" class="createOrderBtn"/>
			</form>
		</div>
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
			<c:forEach var="order" items="${personOrders}">
				<tr>
					<td>${order.orderId}</td>
					<td>160</td>
					<td>${order.status}</td>
					<td>payment</td>
					<td>Feedback</td>
				</tr>
			</c:forEach>

		</table>
		<c:forEach var="order" items="${personOrders}">
		<table>
			<tr>
				<th>Item Name</th>
				<th>Item Units</th>
				<th>Image</th>
				<th>Total Price</th>
			</tr>
			<c:forEach var="itemOrders" items="${order.listOfItemOrders}">
			<tr>
				<td>${itemOrders.item.name}</td>
				<td>${itemOrders.units}</td>
				<td>${itemOrders.image}</td>
				<td>${itemOrders.totalPrice}</td>
			</tr>
			</c:forEach>
		</table>
		</c:forEach>
		
	</div>

	<jsp:include page="/WEB-INF/views/footer.jsp" />
</body>
</html>
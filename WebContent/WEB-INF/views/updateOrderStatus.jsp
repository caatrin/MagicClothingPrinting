<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Update Order Status</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="resources/js/orderStatus.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div>
	<!--<a href="/MagicClothingPrinting/adminOrderHistory">Go to Order History </a>  -->
	<form action="adminOrderHistory">
		<input type="submit" value="Order History" class="orderHistoryBtn"/>
	</form>
</div>


<div id="section">
	<h1>Update Order Status</h1>

	<div>
			<p>
				<label for="orderId">Order Id: </label> <input id="orderId"
					value="${order.orderId}" readonly="readonly" />
			</p>
			<p>
				<label for="orderStatus">Order Status: </label> <input id="orderStatus"
					value="${order.status}"" readonly="readonly" />
			</p>
			<p>
				<label for="customerName">Customer Name: </label> <input
					id="customerName" value="${order.customer.firstName}"" readonly="readonly" />
			</p>

			<table class="table">
				<tbody>
					<tr>
						<th>Items</th>
						<th>Units</th>
						<th>Price per Unit</th>
						<th>Total Price</th>
					</tr>
					<c:forEach var="itemOrder" items="${order.listOfItemOrders}">
					<tr>
						<td>${itemOrder.item.name}</td>
						<td>${itemOrder.units}</td>
						<td>${itemOrder.item.price}</td>
						<td>${itemOrder.totalPrice}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>

			<p>
				<label for="status">Status: </label> 
				<select id="status" name="status">
				<c:forEach var="status" items="${listOfStatuses}">
					<option value="${status.label}">${status.label}</option>
				</c:forEach>
				</select>
			</p>
		<button id="changeStatus" value="Change Status">Change Status</button>

    </div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
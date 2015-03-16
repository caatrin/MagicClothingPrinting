`<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<div>

<h1>Admin Order History</h1>
<table>
<caption>All orders</caption>
<tr>
	<th>Order Id</th>
	<th>Customer Name</th>
	<th>email</th>
	<th>Status</th>
	<th>Action</th>
</tr>

<c:forEach var="order" items="${listOfOrders}">
<tr>
	<td>${order.orderId}</td>
	<td>${order.customer.firstName}</td>
	<td>${order.customer.email}</td>
	<td>${order.status}</td>
	<td><a href="/MagicClothingPrinting/updateOrderStatus?orderId=${order.orderId}">Change Status</a></td>
</tr>
</c:forEach>

</table>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
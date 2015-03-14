<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Order</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script type="text/javascript" src="<c:url value="resources/js/exp.js"/>"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div id="section">

	<div id="orderHistory">
		<form action="customerOrderHistory">
		<input type="submit" value="Customer Order History" class="customerBtn"/>
		</form>
	</div>
	<jsp:include page="/WEB-INF/views/logout.jsp"/>
	
	<div id="items">
			<form:form action="addItemOrder" method="post" modelAttribute="itemOrder">
				<p>
					<label for="name">Select Item: </label>
					
				
					<form:select id="name" name="item" path="item.name">
						<form:option value="select" >Please select item</form:option>
						<form:options items="${listOfItems}" itemLabel="name" itemValue= "name"/>
<%-- 						<c:forEach var="item" items="${listOfItems}"> --%>
<%-- 							<form:options value="${item.name}">${item.name}</form:options> --%>
<%-- 						</c:forEach> --%>
						
					</form:select>
				</p>
				<p>
					<label for="price">Price per Unit: </label>
					<form:input id="price" type="text" readonly="true" path="item.price" />
				</p>
				<p>
					<label for="units">Select Units: </label>
					<form:input id="units" name="units" type="text" path="units"/>
				</p>
				<p>
					<label for="totalPrice">Total Price: </label>
					<form:input id="totalPrice" name="totalPrice" type="text" path="totalPrice" readonly="true" />
				</p>
				<p>
					<label for="image">Upload Image: </label>
					<form:input id="image" name="image" type="file" path="image"/>
				</p>
				
				<p id="buttons">
					<input id="addItem" type="submit" value="Add Item" class="customerBtn">
				</p>
			</form:form>
		</div>
	
	<div id="order">
		<h3>Final Order</h3>
		<table class="table">
				<tbody>
					<tr>
						<th>Items</th>
						<th>Units</th>
						<th>Image</th>
						<th>Total Price</th>
						<th>Options</th>
					</tr>
					<c:forEach var="itemOrder" items = "${listOfItemOrders}">
						<tr>
						<td>${itemOrder.item.name}</td>
						<td>${itemOrder.units}</td>
						<td>${itemOrder.image}</td>
						<td>${itemOrder.totalPrice}</td>
						<td>Delete</td>
						</tr>
					</c:forEach>
				
				</tbody>
			</table>
	</div>
</div>	
	<div id="customerSection">		
		<form action="saveOrder" method="post" class="customerOrderBtn">	
			<input type="submit" value="Save Order" class="customerBtn"/>
		</form>
		<form action="proceedPayment" method="get" class="customerOrderBtn">	
			<input type="submit" value="Proceed Payment" class="customerBtn"/>
		</form>
	</div>	

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
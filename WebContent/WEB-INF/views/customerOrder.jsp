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
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>


<div id="section">
	<div id="items">
			<form action="addItemOrder" method="post">
				<p>
					<label for="name">Item Name: </label><br>
					<select id="name" name="name">
						<option value="T-Shirt">T-Shirt</option>
						<option value="Pants">Pants</option>
						<option value="Sweater">Sweater</option>
					</select>
				</p>
				<p>
					<label for="price">Price per Unit: </label>
					<input id="price" name="price" type="text"
 						value="20" readonly="" />
				</p>

				<p>
					<label for="units">Select Units: </label>
					<input id="units" name="units" type="text"
 						value="2" />
				</p>
				<p id="buttons">
					<input id="addItem" type="submit" value="Add Item">
				</p>
			</form>
		</div>
	
	<div id="order">
		<h3>Final Order</h3>
		
		<form action="payment" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>Items</th>
						<th>Units</th>
						<th>Total Price</th>
						<th>Options</th>
					</tr>
					<c:forEach var="itemOrder" items = "${listOfItemOrders}">
						<tr>
						<td>${itemOrder.item.name}</td>
						<td>${itemOrder.units}</td>
						<td>${itemOrder.totalPrice}</td>
						<td>Delete</td>
						</tr>
					</c:forEach>
				
				</tbody>
			</table>
			
			<input type="submit" value="Proceed Payment"/>
		</form>
		
			
			
		
		
	</div>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
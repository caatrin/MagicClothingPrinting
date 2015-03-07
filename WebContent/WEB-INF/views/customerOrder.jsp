<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Order</title>
</head>
<body>

<div id="header">

</div>

<div id="section">
	<div id="items">
			<form action="addItem" method="post">
				<p>
					<label for="itemName">Item Name: </label><br>
					<select id="itemName" name="itemName">
						<option value="T-Shirt">T-Shirt</option>
						<option value="Pants">Pants</option>
						<option value="Sweater">Sweater</option>
					</select>
				</p>
				<p>
					<label for="pricePerUnit">Price per Unit: </label>
					<input id="pricePerUnit" name="pricePerUnit" type="text"
 						value="pricePerUnit" readonly="" />
				</p>

				<p>
					<label for="itemUnits">Select Units: </label>
					<input id="itemUnits" name="itemUnits" type="text"
 						value="itemUnits" />
				</p>
				<p id="buttons">
					<input id="addItem" type="submit" value="Add Item">
				</p>
			</form>
		</div>
	
	<div id="order">
		<h3>Final Order</h3>
		
		<form action="orderStatus" method="post">
			<table class="table">
				<tbody>
					<tr>
						<th>Items</th>
						<th>Units</th>
						<th>Total Price</th>
						<th>Options</th>
					</tr>
				
				</tbody>
			</table>
			
			<input type="submit" value="Proceed Payment"/>
		</form>
		
			
			
		
		
	</div>
</div>

</body>
</html>
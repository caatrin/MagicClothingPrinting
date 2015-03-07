<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magic Printing Clothing</title>
</head>
<body>
<h1>Order Payment</h1>
<form action = "payment" method="post">
	<fieldset>
		<legend>Payment Information</legend>
		<p>
			<form:errors path="*" cssStyle="color : red;" />
		</p>
		<p>
			<label for="customerName">Customer Name: </label>
			<input name="customerName"  type="text" value="tester" readonly="true" />
		</p>
		<p>
			<label for="orderId">Order Id: </label>
			<input name="orderId"  type="text" value="P876" readonly="true" />
		</p>
		<p>
			<label for="total">Total: </label>
			<input name="total" type="text"  value="1650" readonly="true"/>
		</p>
		<p>
			<label for="paymentType">Payment Type: </label>
			<label><input type="radio" name="paymentType" value="Credit Card" checked/>Credit Card</label>
			<label><input type="radio" name="paymentType" value="Debit Card"/>Debit Card</label>		
		</p>
		<p>
			<label for="cardNumber">Card Number: </label>
			<input name="cardNumber"  type="text" required />
		</p>		
	</fieldset>
	
	<p id="buttons">
             <input id="submit" type="submit" value="Pay!"  />
        </p>
</form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Order Payment</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp" />

<div id="section">
<h1>Order Payment</h1>
<form action = "thankyou" method="post">
	<fieldset>
		<legend>Payment Information</legend>
		<p>
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
			<input name="cardNumber"  type="text" />
		</p>		
	</fieldset>
	
	<p id="buttons">
             <input id="submit" type="submit" value="Pay!"  />
        </p>
</form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
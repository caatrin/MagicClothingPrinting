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
<jsp:include page="/WEB-INF/views/logout.jsp"/>
<h1>Order Payment</h1>
<form:form modelAttribute ="newPayment"  action = "payment" method="post" class="paymentFormCss">
	<fieldset>
		<legend>Payment Information</legend>
		<p>
		</p>
		<p>
			<label for="orderId">Order Id: </label>
			<form:input name="orderId"  type="text"  path = "order.orderId" value = "${order.orderId}" readonly="true" class="paymentPropertyOrderId"/>
		</p>
		<p>
		
			<label for="transactionAmount">Transaction Amount: </label>
			<form:input name="transactionAmount" type="text" path ="transactionAmount" value="${order.orderTotal}" readonly="true" class="paymentPropertyTotal"/>
		</p>
		<p>
			<label for="paymentType">Payment Type: </label>
			<label><form:radiobutton name="paymentType" path="paymentType" value="Credit Card" checked="true"/>Credit Card</label>
			<label><form:radiobutton name="paymentType" path="paymentType" value="Debit Card"/>Debit Card</label>		
		</p>
		<p>
			<label for="cardNumber">Card Number: </label>
			<form:input name="cardNumber" path="cardNumber" type="text" class="paymentPropertyCardNumber"/>
		</p>
		<p>
			<label for="expirationDate">Expiration Date: </label>
			<form:input name="expirationDate"  path="expirationDate" type="text" class="paymentPropertyExpirationDate"/>
		</p>	
		<p>
			<label for="securityNumber">security number: </label>
			<form:input name="securityNumber"  path="securityNumber" type="text" class="paymentPropertySecurityNumber"/>
		</p>	
	</fieldset>
	
	<p id="buttons">
             <input id="paymentBtn" type="submit" value="Pay!"  />
        </p>
</form:form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
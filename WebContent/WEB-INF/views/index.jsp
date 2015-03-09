<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Magic Clothing Printing</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="section">
	<h1>Welcome to the Magic Clothing Printing</h1>

	<form action="displaysignup">
		<input type="submit" value="Sign up" />
	</form>
	<form action="login">
		<input type="submit" value="Log in" />
	</form>
	<form action="displayPayment">
		<input type="submit" value="payment" />
	</form>
	<form action="feedback">
		<input type="submit" value="Feedback" />
	</form>
	<form action="updateOrderStatus">
		<input type="submit" value="Update Status" />
	</form>
	<form action="displayCustomerOrder">
		<input type="submit" value="Customer Order History" />
		</form>
	<form action="displayAdminHistory">
		<input type="submit" value="Admin Order History" />
	</form>
</div>
	
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
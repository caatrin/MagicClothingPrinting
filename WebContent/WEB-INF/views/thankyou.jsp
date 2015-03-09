<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Thank you</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="section">
<h1>Thank you for your order!</h1>

<h2>Our staff will contact you soon to confirm pick up!</h2>

<a href="/MagicClothingPrinting/customerOrderHistory">Go to your Order History</a>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
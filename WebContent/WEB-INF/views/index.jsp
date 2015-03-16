<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Magic Clothing Printing</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/headerWithouLogout.jsp"/>

<div id="lang">
	<a href="?language=en" >English</a>|<a href="?language=ro" >Romanian</a>|<a href="?language=es" >Spanish</a>						
</div>

<div id="indexSection">

	<form action="displaysignup" class="indexMarginTop">
		<input type="submit" value="<spring:message code="index.signup"/>"  class="loginBtnClass"/>
	</form>
	<form action="displaylogin" class="indexMarginTop">
		<input type="submit" value="<spring:message code="index.login"/>" class="loginBtnClass"/>
	</form>
</div>

<h1 id="mainHead"><spring:message code="index.welcomeTitle"/></h1>
	
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
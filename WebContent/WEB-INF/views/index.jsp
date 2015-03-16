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
<jsp:include page="/WEB-INF/views/headerWithouLogout.jsp"/>

<div id="indexSection">

	<form action="displaysignup" class="indexMarginTop">
		<input type="submit" value="Sign up"  class="loginBtnClass"/>
	</form>
	<form action="displaylogin" class="indexMarginTop">
		<input type="submit" value="Log in" class="loginBtnClass"/>
	</form>
</div>
<h1 id="mainHead">Welcome to the Magic Clothing Printing</h1>
	
<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Magic Clothing Printing</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/headerWithouLogout.jsp"/>
<div class="aboutUsDiv">
	<blockquote id="blockquoteCss">
		We are Kate and Marcela two crazy girls that like Unicorns. We are from Moldova (a country in Eastern Europe located 
		between Romania to its west and Ukraine to its north) and Colombia (a country in South America).
		We enjoyed developing this project, we learned a lot and had fun at the same time...
	</blockquote>
	<img id="collage" alt="WAA Collage" src="resources/img/WAA_Collage.png"/>
	<blockquote id="blockquoteCss2">We also want to special thank Luis Fernandez who advised us on our project business logic
	and Arun Kumar who advised us with the CSS design of our project.
	Also we would like to thank our teacher Joe Bruen for sharing his valuable knowledge about Spring MVC.</blockquote>
		
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Magic Printing Clothing</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/headerWithouLogout.jsp"/>

<div id="section">
<h1>Log in</h1>
<form:form modelAttribute = "loginCustomer" action="customerOrder"  class="loginFormCss">
	<fieldset>
		<legend>Log in</legend>
		<p>
			<label for="email">Email: </label>
			<input type="text" id="usernameEmail" name="email" class="loginpropertyEmail"/>
		</p>
		<p>
			<label for="password">password: </label>
			<input id="password" name="password" type="password" class="loginpropertyPassword"/>
		</p>
		</fieldset>
		<p>
		<form:errors path="*" cssStyle="color : red;"/>
		</p>
	<p id="buttons">
             <input id="loginBtn" type="submit" value="Log in"  />
        </p>

</form:form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
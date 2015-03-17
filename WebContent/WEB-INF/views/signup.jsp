<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/headerWithouLogout.jsp"/>

<div id="section">
<h1>Sign up with the best online printing service</h1>
<form:form modelAttribute="newCustomer" action = "signup" class="signUpFormCss">
	<fieldset>
		<legend>Signup</legend>
		
		<p>
			<label for="firstName">First Name: </label>
			<form:input id="firstName" path="firstName" type="text"  class="propertyClassFname"/>
			
			<div>
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="lastName">Last Name: </label>
			<form:input id="lastName" path="lastName" type="text" class="propertyClassLname"/>
			
			<div>
 				<form:errors path="lastName" cssStyle="color : red;"  /> 
 			</div>
		</p>
		<p>
			<label for="email">email: </label>
			<form:input id="email" path="email" type="text"  class="propertyClassEmail"/>
			
			<div>
 				<form:errors path="email" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="street">Street: </label>
			<form:input id="street" path="street" type="text" class="propertyClassStreet"/>
			
			<div >
 				<form:errors path="street" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="city">City: </label>
			<form:input id="city" path="city" type="text"  value="Fairfield" readonly="true" class="propertyClassCity"/>
		</p>
		<p>
			<label for="state">State: </label>
			<form:input id="state" path="state" type="text"  value="Iowa" readonly="true" class="propertyClassState"/>
		</p>
		<p>
			<label for="zipcode">Zip Code: </label>
			<form:input id="zipcode" path="zipcode" type="text" class="propertyClassZip"/>
			
			<div>
 				<form:errors path="zipcode" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="phoneNumber">Phone number: </label>
			<form:input id="phoneNumber" path="phoneNumber" type="text" class="propertyClasspNo"/>
			
			<div>
 				<form:errors path="phoneNumber" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="password">Password: </label>
			<form:input id="password" path="password" type="password" class="propertyClassPass"/>
			
			<div>
 				<form:errors path="password" cssStyle="color : #EF004C;" /> 
 			</div>
		</p>		
		<p>
			<label for="confirmPassword">Confirm Password: </label>
			<form:input id="confirmPassword" path="confirmPassword" type="password" class="propertyClassCpass"/>
			
			<div>
 				<form:errors path="confirmPassword" cssStyle="color : red;" /> 
 			</div>
		</p>
		
	</fieldset>
	
	<p id="buttons">
             <input id="signupBtn" type="submit" value="Sign up"  />
        </p>

</form:form>
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
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
<h1>Signup</h1>
<form:form modelAttribute="newCustomer" action = "signup">
	<fieldset>
		<legend>Signup</legend>
		<p>
			<form:errors path="*" cssStyle="color : red;" />
		</p>
		<p>
			<label for="firstName">First Name: </label>
			<form:input id="firstName" path="firstName" type="text" />
			
			<div>
 				<form:errors path="firstName" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="lastName">Last Name: </label>
			<form:input id="lastName" path="lastName" type="text" />
			
			<div>
 				<form:errors path="lastName" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="email">email: </label>
			<form:input id="email" path="email" type="text" />
			
			<div>
 				<form:errors path="email" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="street">Street: </label>
			<form:input id="Street" path="Street" type="text" />
			
			<div >
 				<form:errors path="Street" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="city">City: </label>
			<form:input id="city" path="city" type="text"  value="Fairfield" disabled="true"/>
		</p>
		<p>
			<label for="state">State: </label>
			<form:input id="state" path="state" type="text"  value="Iowa"  disabled="true"/>
		</p>
		<p>
			<label for="zipcode">Zip Code: </label>
			<form:input id="zipcode" path="zipcode" type="text" />
			
			<div>
 				<form:errors path="zipcode" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="phoneNumber">Phone number: </label>
			<form:input id="phoneNumber" path="phoneNumber" type="text" />
			
			<div>
 				<form:errors path="phoneNumber" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="password">Password: </label>
			<form:input id="password" path="password" type="text" />
			
			<div>
 				<form:errors path="password" cssStyle="color : red;" /> 
 			</div>
		</p>		
		<p>
			<label for="confirmPassword">Confirm Password: </label>
			<form:input id="confirmPassword" path="confirmPassword" type="text" />
			
			<div>
 				<form:errors path="confirmPassword" cssStyle="color : red;" /> 
 			</div>
		</p>
		
	</fieldset>
	
	<p id="buttons">
             <input id="submit" type="submit" value="Sign up"  />
        </p>

</form:form>
</body>
</html>
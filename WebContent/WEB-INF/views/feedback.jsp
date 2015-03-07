<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Feedback</title>
</head>
<body>

<div>
	<h2>We would like to hear your feedback!</h2>
	
	<form:form modelAttribute="newFeedback" action="giveFeedback">
		<p><label for="orderId">Order Id: </label>
			<form:input id="orderId" path="orderId" type="text" value="orderId" />
		</p>
		<p>
			<h4>Please rate our service:</h4> 
			<label><form:radiobutton path="rating" value="1"/> 1  </label>
       		<label><form:radiobutton path="rating" value="2"/> 2  </label>
        	<label><form:radiobutton path="rating" value="3"/> 3  </label>
        	<label><form:radiobutton path="rating" value="4"/> 4  </label>
        	<label><form:radiobutton path="rating" value="5"/> 5  </label>
        	
		</p>
		<p>
			<label for="positive">Positive</label>
			<form:textarea id="positive" path="positive"/>
		</p>
		<p>
			<label for="negative">Negative</label>
        	<form:textarea id="negative" path="negative"/>
		</p>
    	<p id="buttons">
        	<input id="submit" type="submit" value="Give Feedback">
        </p>
	</form:form>
	
</div>

</body>
</html>
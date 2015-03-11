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
<link rel="stylesheet" href=<c:url value="resources/css/magicclothing.css"/>>
</head>
<body>
<jsp:include page="/WEB-INF/views/header.jsp"/>

<div id="section">
	<h2>We would like to hear your feedback!</h2>
	
	<form:form modelAttribute="newFeedback" action="giveFeedback" class="feedbackFormCss">
		<p>
  		     <form:errors path="*" cssStyle="color : red;" /> 
        </p>
	
		<p><label for="order">Order Id: </label>
			<form:input id="order" path="order" type="text" value="orderId" class="feedbackPropertyOrderId" />
		</p>
		<p>
			<h4>Please rate our service:</h4> 
			<label class="feedbackratingCss"><form:radiobutton path="rating" value="1"/> 1  </label>
       		<label class="feedbackratingCss"><form:radiobutton path="rating" value="2"/> 2  </label>
        	<label class="feedbackratingCss"><form:radiobutton path="rating" value="3"/> 3  </label>
        	<label class="feedbackratingCss"><form:radiobutton path="rating" value="4"/> 4  </label>
        	<label class="feedbackratingCss"><form:radiobutton path="rating" value="5"/> 5  </label>
        	
        	<div style="text-align: center;">
 				<form:errors path="rating" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="positive">Positive</label>
			<form:textarea id="positive" path="positive" class="feedbackPropertyPositive"/>
			
			<div style="text-align: center;">
 				<form:errors path="positive" cssStyle="color : red;" /> 
 			</div>
		</p>
		<p>
			<label for="negative">Negative</label>
        	<form:textarea id="negative" path="negative" class="feedbackPropertyNegative"/>
        	
        	<div style="text-align: center;">
 				<form:errors path="negative" cssStyle="color : red;" /> 
 			</div>
		</p>
    	<p id="buttons">
        	<input id="feedbackBtn" type="submit" value="Give Feedback">
        </p>
	</form:form>
	
</div>

<jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>
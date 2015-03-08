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
<h1>Log in</h1>
<form action = "customerOrder" method="post">
	<fieldset>
		<legend>Log in</legend>
		<p>
			<label for="email">Email: </label>
			<input type="text" id="usernameEmail" name="email" />
		</p>
		<p>
			<label for="password">password: </label>
			<input id="password" name="password" type="password" />
		</p>
		</fieldset>
	
	<p id="buttons">
             <input id="submit" type="submit" value="Log in"  />
        </p>

</form>
</body>
</html>
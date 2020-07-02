<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<h1>Dojo Location</h1>
	<form:form action="/newDojo" method="POST" modelAttribute="dojo">
		<p>
			<form:errors path="location" /><br />
			<form:label path="location">Name:</form:label>
			<form:input path="location" />
		</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true" %>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
</head>
<body>
	<form:form action="/newNinja" method="post" modelAttribute="ninja">
    <p>
        <form:errors path="dojo.id"/><br />
        <form:label path="dojo.id">Location</form:label>
        <form:select path="dojo.id">
        <c:forEach  items="${dojos}" var="dojo">
        <form:option value="${dojo.id}" label="${dojo.location}" />
        </c:forEach>
        </form:select>
    </p>
		<p>
        	<form:errors path="firstName"/> <br />
       		<form:label path="firstName">First Name:</form:label>
        	<form:input path="firstName" type="text"/>
    	</p>
    	<p>
    		<form:errors path="lastName" />
    		<form:label path="lastName">Last Name:</form:label>
    		<form:input path="lastName" type="text" />
    	</p>
    	<p>
    		<form:errors path="age" />
    		<form:label path="age">Age:</form:label>
    		<form:input path="age" type="text" />
    	</p>
		<input type="submit" value="Create" />
	</form:form>
</body>
</html>
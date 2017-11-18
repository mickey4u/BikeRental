<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>UL Bike Rental</title>
</head>
<body>
<s:actionerror/>
<h1>Register User</h1>
<div id="homePage">
    <s:form action="register">
        <s:textfield name="user.username" label="Index Number" size="20"></s:textfield>
        <s:password name="user.password" label="Password" size="20"></s:password>
        <s:textfield name="user.firstname" label="Firstname" size="20"></s:textfield>
        <s:textfield name="user.lastname" label="Lastname" size="20"></s:textfield>
        <s:textfield name="user.phoneNumber" label="PhoneNumber" size="20"></s:textfield>
        <s:textfield name="user.secretQuestion" label="Secret Question" size="40"></s:textfield>
        <s:textfield name="user.secretAnswer" label="Answer" size="40"></s:textfield>
        <s:submit align="center" value="Register"></s:submit>
        <div id="register"><a href="Login.jsp">Login</a></div>
    </s:form>
</div>
</body>
</html>
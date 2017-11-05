<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>UL Bike Rental</title>
</head>
<body>
<s:actionerror />
<h1>Register User</h1>
<div id="homePage">
	<s:form action="registerAction.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:textfield name="name" key="label.name" size="20" />
    <s:password name="password" key="label.password" size="20" />
<%--     <s:submit method="execute" key="label.register" align="center" /> --%>
    <s:submit value="Register" align="center"/>
</s:form>
</div>
</body>
</html>
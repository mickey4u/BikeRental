<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>UL Bike Rental </title>
<style>
	#homePage{
    position: relative;
    align-content: center;
    margin-top: 16%;
    margin-left: 35%;
}
body{
    background-image: src('icon/UL.png');
    width:100%;
    height:100%;
}
#register
{
    vertical-align: middle;
    position: relative;
    align-content: center;
    padding-left: 111px;
}
</style>
</head>
 
<body>
<h2>UL Bike Rental</h2>
<s:actionerror />
<div id="homePage">
	<s:form action="login.action" method="post">
    <s:textfield name="username" key="label.username" size="20" />
    <s:password name="password" key="label.password" size="20" />
    <s:submit method="execute" key="label.login" align="center" />
    <div id="register"><a href="RegisterUser.jsp">Register User</a></div>
<%--     <s:submit value="Register" action="registerAction" align="center"/> --%>
</s:form>
</div>

</body>
</html>
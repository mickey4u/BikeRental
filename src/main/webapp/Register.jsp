<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>


    <link rel="stylesheet" href="css/bikeRental.css"/>
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/login.css">
    <title>UL Bike Rental</title>
</head>
<body>
<s:actionerror/>
<h1>Register User</h1>
<div id="home">
    <div id="header" style="height: 324px;
    margin-left: 21%;
    width: 50%; ">
        <a class="UL_logo" style="display: block; float: left; background: url(https://www.ul.ie/ee/images/interface/UL_logo_large.jpg) no-repeat; height: 85px; width: 363px; margin-top: 5px;"></a>

        <s:form action="register">
            <s:textfield name="user.username" label="Index Number" size="20"></s:textfield>
            <s:password name="user.password" label="Password" size="20"></s:password>
            <s:textfield name="user.firstname" label="Firstname" size="20"></s:textfield>
            <s:textfield name="user.lastname" label="Lastname" size="20"></s:textfield>
            <s:textfield name="user.phoneNumber" label="PhoneNumber" size="20"></s:textfield>
            <s:textfield name="user.secretQuestion" label="Secret Question" size="40"></s:textfield>
            <s:textfield name="user.secretAnswer" label="Answer" size="40"></s:textfield>
            <s:submit align="center" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" style="float: right; margin-right: 50%" value="Register"></s:submit>
        </s:form>
    </div>

</div>
</body>
</html>
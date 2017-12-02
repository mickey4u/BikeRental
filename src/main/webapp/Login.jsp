<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/grid.locale-en.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>
    <link rel="stylesheet" href="css/jquery-ui.css">
    <link rel="stylesheet" href="css/login.css">
    <title>UL Bike Rental </title>
</head>

<body>
<h2>UL Bike Rental</h2>
<s:actionerror/>
<div id="homePage">
    <div id="header" style="height: 132px;">
        <a class="UL_logo" style="display: block; float: left; background: url(https://www.ul.ie/ee/images/interface/UL_logo_large.jpg) no-repeat; height: 85px; width: 363px; margin-top: 5px;" href="localhost:8080/bikerental/login"></a>
    </div>
    <s:form action="login">
        <s:textfield name="user.username" size="20"></s:textfield>
        <s:password name="user.password" size="20"></s:password>
        <s:submit align="center" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" value="Login"></s:submit>
        <div id="register"><a href="Register.jsp">Register User</a></div>
    </s:form>
</div>

</body>
</html>
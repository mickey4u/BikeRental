<%--
  Created by IntelliJ IDEA.
  User: Mayank
  Date: 02-12-2017
  Time: 01:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="float" uri="/struts-jquery-tags" %>
<html>
<head>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.jqGrid.min.js"></script>
    <script src="js/grid.locale-en.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>

    <link rel="stylesheet" href="css/bikeRental.css"/>
    <link rel="stylesheet" href="css/ui.jqgrid.css">
    <link rel="stylesheet" href="css/jquery-ui.css">

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bikeLocator-1.1-min.js"></script>
    <script type="text/javascript" src="js/bikes.js"></script>
    <title>Rental History</title>
    <div id="header" style="height: 132px;">
        <a class="UL_logo" style="display: block; float: left; background: url(https://www.ul.ie/ee/images/interface/UL_logo_large.jpg) no-repeat; height: 85px; width: 363px; margin-top: 5px;" href="localhost:8080/bikerental/login"></a>
    </div>
    <div id="dialog" title="Alert message" style="display: none">
        <div class="ui-dialog-content ui-widget-content">
            <p>
                <span class="ui-icon ui-icon-alert" style="float: left; margin: 0 7px 20px 0"></span>
                <label id="lblMessage">
                </label>
            </p>
        </div>
    </div>
    <div style="float: right; position: relative; top: -54px; width: 99%">
        <ul class="tabs"><a href="rentalHistory.jsp" class="tabsfont">Rental History</a></ul>
        <ul class="tabs"><a class="tabsfont">Pre-Booking</a></ul>
        <ul class="tabs"><a class="tabsfont">Offers</a></ul>
        <ul class="tabs"><a href="https://www.ul.ie/" class="tabsfont">UL</a></ul>
        <ul class="tabs"><a class="tabsfont">Bikes</a></ul>
        <ul class="tabs"><a id="raiseTicket" class="tabsfont">Contact Admin</a></ul>
        <ul class="tabs"><a href="<s:url action="logout"/>" class="tabsfont">SignOut</a></ul>
    </div>
    <div id="secondWindow"><table id="grid"></table></div>
</head>
<body>
<script type="text/javascript">
    $(document).ready(function () {
        loadRentalHistory();
    });
</script>
</body>
</html>

<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="float" uri="/struts-jquery-tags" %>
<html>
<head>
<%--
    <a>Library Files</a>
--%>
    <script src="js/jquery-3.2.1.min.js"></script>
    <script src="js/jquery-ui.js"></script>
    <script src="js/jquery.jqGrid.min.js"></script>
    <script src="js/grid.locale-en.js"></script>
    <script src="https://code.jquery.com/ui/1.11.4/jquery-ui.min.js"></script>


    <link rel="stylesheet" href="css/bikeRental.css"/>
    <link rel="stylesheet" href="css/ui.jqgrid.css">
    <link rel="stylesheet" href="css/jquery-ui.css">
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsNPCh1hdLeGbQjYxj812X14w4rN64afI&callback=initMap"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bikeLocator-1.1-min.js"></script>
    <script type="text/javascript" src="js/bikes.js"></script>
    <title>UL Bike Rental</title>
    <style></style>
</head>
<body>
<h2 style="font-size: 98%;position:relative; margin-left: 87%; top:93px; font-family: 'Bookman Old Style',serif">Howdy, <s:property value="username"/>...!</h2>
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
    <div style="float: right; position: relative; top: -54px; width: 100%">
        <ul class="tabs"><a class="tabsfont">Account</a></ul>
        <ul class="tabs"><a class="tabsfont">Pre-Book</a></ul>
        <ul class="tabs"><a class="tabsfont">Offers</a></ul>
        <ul class="tabs"><a href="https://www.ul.ie/" class="tabsfont">UL</a></ul>
        <ul class="tabs"><a class="tabsfont">Bikes</a></ul>
        <ul class="tabs"><a class="tabsfont">Contact</a></ul>
        <ul class="tabs"><a href="<s:url action="logout"/>" class="tabsfont">SignOut</a></ul>
    </div>
    <div id="map" style="width: 96%; height: 60%; float: right"></div>
    <div id="secondWindow" style="display: none"><table id="grid"></table></div>
    <div id="lowerPanel">
        <button id="button" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" onclick="checkSelection()">View Bikes</button>
    </div>
    <button id="goBack" style="display: none;" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit">Back</button>

    <script type="text/javascript">
    $(document).ready(function () {
        navigator.geolocation.getCurrentPosition(showPosition);
            $("#goBack").click(function (){
                navigator.geolocation.getCurrentPosition(showPosition);
                $("#secondWindow").hide();
                $("#goBack").hide();
                $("#map").show();
                $("#lowerPanel").show();
            })
        });
    </script>
</body>
</html>
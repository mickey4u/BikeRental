<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib prefix="sj" uri="/struts-jquery-tags" %>
<%@ taglib prefix="float" uri="/struts-jquery-tags" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script src="//code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://trirand.com/blog/jqgrid/js/jquery.jqGrid.min.js"></script>
    <script src="http://trirand.com/blog/jqgrid/js/i18n/grid.locale-en.js"></script>
    <script src="//code.jquery.com/mobile/1.5.0-alpha.1/jquery.mobile-1.5.0-alpha.1.min.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>

    <link rel="stylesheet" href="css/bikeRental.css"/>
    <link rel="stylesheet" href="http://trirand.com/blog/jqgrid/themes/ui.jqgrid.css">
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <script async defer src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsNPCh1hdLeGbQjYxj812X14w4rN64afI&callback=initMap"></script>

    <script type="text/javascript" src="${pageContext.request.contextPath}/js/bikeLocator-1.1-min.js"></script>
    <script type="text/javascript" src="js/bikes.js"></script>
    <title>UL Bike Rental</title>
    <style></style>
</head>
<body>
    <div id="header" style="height: 117px;">
        <h2 style="font-size: 98%;position:relative; top:93px; font-family: 'Bookman Old Style'">Howdy, <s:property value="username"/>...!</h2>
        <img src="images/Logo.jpg" alt="logo" style="width: 399px;height: 126px; position: relative; top: -37%; float: left;overflow: auto;margin-left: 31%;">
        <div id="signOn" class="sign-In">
            <img id="signInLogo" class="signInLogo">
            <a href="<s:url action="logout"/>">SignOut</a>
        </div>
    </div>
    <div style="float: right; position: relative; top: -54px; width: 100%">
        <ul class="tabs"><a class="tabsfont">Account</a></ul>
        <ul class="tabs"><a class="tabsfont">Offers</a></ul>
        <ul class="tabs"><a class="tabsfont">Ticket</a></ul>
        <ul class="tabs"><a class="tabsfont">UL</a></ul>
        <ul class="tabs"><a class="tabsfont">Bikes</a></ul>
        <ul class="tabs"><a class="tabsfont">Travel</a></ul>
    </div>
    <div id="map" style="width: 96%; height: 60%; float: right"></div>
    <div id="secondWindow" style="display: none"><table id="grid"></table></div>
    <div id="lowerPanel">
        <button id="button" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" onclick="fetchAvailability()">View Bikes</button>
    </div>
    <button id="goBack" style="display: none;"class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit">Back</button>
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
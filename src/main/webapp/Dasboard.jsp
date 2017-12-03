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
    <script type="text/javascript" src="js/tickets.js"></script>
    <title>UL Bike Rental</title>
    <style></style>
</head>
<body>
<%--
<input value="${firstname}"/>
--%>
<h2 style="font-size: 98%;position:relative; margin-left: 87%; top:93px; font-family: 'Bookman Old Style',serif">Howdy, <s:property value="username"/></h2>
    <div id="header" style="height: 132px;">
        <a class="UL_logo" style="display: block; float: left; background: url(https://www.ul.ie/ee/images/interface/UL_logo_large.jpg) no-repeat; height: 85px; width: 363px; margin-top: 5px;"></a>
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
        <ul class="tabs"><a id="rentalHistory" onclick="loadRentalHistory();" class="tabsfont">Rental History</a></ul>
        <ul class="tabs"><a class="tabsfont">Pre-Booking</a></ul>
        <ul class="tabs"><a class="tabsfont">Student Offers</a></ul>
        <ul class="tabs"><a href="https://www.ul.ie/" class="tabsfont">UL Link</a></ul>
        <ul class="tabs"><a class="tabsfont">Latest Bikes</a></ul>
        <ul class="tabs"><a id="raiseTicket" class="tabsfont">Contact Admin</a></ul>
        <ul class="tabs"><a href="<s:url action="logout"/>" class="tabsfont">LogOff</a></ul>
    </div>
    <div id="map" style="width: 96%; height: 60%; float: right"></div>
    <div id="secondWindow" style="display: none"><table id="grid"></table></div>
    <div id="viewHistory" style="display: none"><table id="grid1"></table></div>
    <form id="ticketForm" style="display: none">
        <textarea name="fullName" placeholder="Write your Message here" id="t1" cols="40" rows="5"></textarea>
        <br/>
        <a>Mobile Number :</a><input type="text" id="t2" name="mobileNumber" />
        <br/>
        <a><b>Severity :</b></a>
        <select id="s1" name="numeral">
            <option value="Low">Low</option>
            <option value="Medium">Medium</option>
            <option value="High">High</option>
        </select>
        <br/><br/>
        <button class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" value="Raise Ticket" style="display: none" onclick="raiseTicket()" id="b1">
            Submit
        </button>
    </form>
    <div id="lowerPanel">
        <button id="button" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" onclick="checkSelection()">View Bikes</button>
        <button id="returnBike" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit" onclick="returnBike()">Return Bike</button>
    </div>
    <button id="goBack" style="display: none;" class="ui-button ui-widget ui-corner-all ui-shadow ui-button-inherit">Back</button>

    <script type="text/javascript">
        /*
        * Global Variables
        * */
        var selectedBikeJson = "";
        var selectedBikeSpot="";
        var username = $('h2')[0].innerHTML;

    $(document).ready(function () {
        navigator.geolocation.getCurrentPosition(showPosition);
            $("#goBack").click(function (){
                navigator.geolocation.getCurrentPosition(showPosition);
                $("#secondWindow").hide();$("#goBack").hide();
                $("#viewHistory").hide();
                $("#map").show();$("#lowerPanel").show();
            });
            $("#raiseTicket").click(function () {
                $("#secondWindow").hide();$("#goBack").hide();
                $("#map").hide();$("#lowerPanel").hide();
                $("#ticketForm").show();
                $("#b1").show();
            })
        $("#rentalHistory").click(function () {
            $("#secondWindow").hide();$("#goBack").hide();
            $("#map").hide();$("#lowerPanel").hide();
            $("#viewHistory").css({
                display: "block"
            });

        })
        });
    </script>
</body>
</html>
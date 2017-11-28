<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.14/themes/base/jquery-ui.css"></script>
    <link rel="stylesheet" href="https://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
    <script type="text/javascript" src="http://maps.google.com/maps/api/js"></script>
    <link rel="stylesheet" href="css/bikeRental.css"/>
    <script async defer
            src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsNPCh1hdLeGbQjYxj812X14w4rN64afI&callback=initMap"></script>
    <script type="text/javascript" src="http://gmap3.net/js/gmap3-4.1-min.js"></script>
    <script type="text/javascript" src="js/bikeLocator-1.1-min.js"></script>
    <title>UL Bike Rental</title>
    <style></style>
</head>
<body>
<h2>Howdy, <s:property value="username"/>...!</h2>
<div id="view">

    <div id="topbar" data-theme='a'>
        <div id="signOn" class="sign-In">
            <img id="signInLogo" class="signInLogo">
            <a href="<s:url action="logout"/>">SignOut</a>
        </div>
        <div class="tabs">
            <span class="tabsfont">Account</span>
        </div>
        <div class="tabs">
            <span class="tabsfont">Offers</span>
        </div>
        <div class="tabs">
            <span class="tabsfont">Raise Ticket</span>
        </div>
        <div class="tabs">
            <span class="tabsfont">UL</span>
        </div>
        <div class="tabs">
            <span class="tabsfont">Bikes</span>
        </div>
        <div class="tabs">
            <span class="tabsfont">Travel</span>
        </div>
    </div>
    <div>
        <div id="map" style="width: 100%; height: 90%;"></div>
    </div>
    <div id="lowerPanel">

        <button id="button" class="ui-button ui-widget ui-corner-all"
                onclick="fetchAvailability()">View Bikes</button>
    </div>

</div>


<script>
    $(document).ready(function () {
        console.log("document loaded");
        navigator.geolocation.getCurrentPosition(showPosition);
    });

    function fetchAvailability() {
        var loc = "The Stables";
        alert(loc);
        {
            $.ajax({
                type: 'GET',
                url: "<s:url action='fetchAvailabilityData'/>",
                dataType : 'text/javascript',
                data: {bikeSpotLocation: loc},
                success: function(data) {
                    alert("Some exception occurred! Please try again.");
                }
            });
        }
    }
</script>

</body>
</html>
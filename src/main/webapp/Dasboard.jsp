<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
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

<div id="topbar" data-theme='a'>
    <img id="bbcLogo" src="images/bbc-logo.png">
    <div id="signOn" class="sign-In">
        <img id="signInLogo" class="signInLogo" src="images/signIN.png">
        <%--  <span id="signInfont" class="signInfont">Sign Out</span>--%>
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
    <div>
        <div id="map" style="width: 500px; height: 400px;"></div>
    </div>
    <button id="button" data-role="button" onclick="fetchAvailability">View Bikes</button>
</div>
<script>
    $(document).ready(function () {
        console.log("document loaded");
        navigator.geolocation.getCurrentPosition(showPosition);
        $('#button').click(function () {
            alert("welcome");
            fetchAvailability();
        });

    });

    function fetchAvailability() {
        var loc = "The Stables";
        {
            $.ajax({
                type: "POST",
                url: "<s:url action='fetchAvailability'/>",
                dataType: 'text/javascript',
                data: {
                    bikeSpot: loc
                },
                success: function (results) {

                    alert("Some exception occurred! Please try again.");

                }
            });
        }
    }
</script>

</body>
</html>
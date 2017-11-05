<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<script src="https://code.jquery.com/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="http://maps.google.com/maps/api/js">  </script>
 <script async defer
      src="https://maps.googleapis.com/maps/api/js?key=AIzaSyDsNPCh1hdLeGbQjYxj812X14w4rN64afI&callback=initMap">
 </script>


<%-- <script type="text/javascript" src="http://gmap3.net/js/gmap3-4.1-min.js"></script> --%>
<%-- <script type="text/javascript" src="${pageContext.request.contextPath}/js/bikeLocator-1.1-min.js"></script> --%>

<title>UL Bike Rental</title>
<style></style>
</head>
<body>
	<h2>Howdy, <s:property value="username" />...!</h2>	
	<div>
  		<div id="map" style="width: 500px; height: 400px;"></div>
	</div>
	<script>
    $( document ).ready(function() {
        console.log( "document loaded" );
        navigator.geolocation.getCurrentPosition(showPosition);
    });
 
    </script>
      
</body>
</html>
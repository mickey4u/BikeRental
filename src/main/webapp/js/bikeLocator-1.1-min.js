var x = document.getElementById("demo");
var lat=''; var long = '';
function showPosition(position) {
	lat = position.coords.latitude;
	long = position.coords.longitude;
	loadMap(lat, long);
}



function loadMap(lattitude, longitude)
{
	var image = 'https://developers.google.com/maps/documentation/javascript/examples/full/images/beachflag.png';
	var locations =
		[[
	        "Milford Centre",
	        52.670507,
	        -8.5735550
	    ],
	    [
	    	"Current Location",
	    	lattitude,
	    	longitude
	    ],
	    [
	        "The Stables",
	        52.672946,
	        -8.5698254
	    ],
	    [
	        "Lero Centre for excellence",
	        52.674576,
	        -8.5771720
	    ],
	    [
	        "A School Of Fish",
	        52.674492,
	        -8.5737320
	    ],
	    [
	        "Dromroe Village",
	        52.679088,
	        -8.5735807
	    ]]
	console.log(locations);
	    var map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 15,
	    // center: new google.maps.LatLng(-33.92, 151.25),
	    center: new google.maps.LatLng(52.674492,-8.5737320),
	    mapTypeId: google.maps.MapTypeId.ROADMAP
	    });
	    var infowindow = new google.maps.InfoWindow();
	    var marker, i;
	    for (i = 0; i < locations.length; i++)
	    {
	    	if(i==1)
	    	{
	    			marker = new google.maps.Marker({
	    	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
	    	        icon: image,
	    	        scaledSize: new google.maps.Size(50, 50), // scaled size
	    	        origin: new google.maps.Point(0,0), // origin
	    	        anchor: new google.maps.Point(0, 0), // anchor
	    	        map: map
	    	      });
	    	}
	    	else
	    		{
	    			marker = new google.maps.Marker({
	    	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
//	    	        icon: "icon/icon1.png",
//	    	        scaledSize: new google.maps.Size(1, 1), // scaled size
	    	        map: map
	    	      });
	    		}

	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        return function() {
	          infowindow.setContent(locations[i][0], locations[i][6]);
	          infowindow.open(map, marker);
//	          fetchAvaibility();
	        }
	      })(marker, i));
//	       marker.addListener('click', function() {
//	         });
	    }

}
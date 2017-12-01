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
	        "Stables",
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
	    var map = new google.maps.Map(document.getElementById('map'), {
	    zoom: 14,
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
                        title: locations[i][0],
	    	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
	    	        scaledSize: new google.maps.Size(80, 80), // scaled size
                    animation: google.maps.Animation.DROP,
	    	        origin: new google.maps.Point(0,0), // origin
	    	        anchor: new google.maps.Point(0, 0), // anchor
	    	        map: map
	    	      });
	    	}
	    	else
	    		{
	    			marker = new google.maps.Marker({
                        title: locations[i][0],
	    	        position: new google.maps.LatLng(locations[i][1], locations[i][2]),
                    animation: google.maps.Animation.DROP,
	    	        map: map
	    	      });
	    		}

	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        return function() {
	          infowindow.setContent(locations[i][0], locations[i][6]);
	          infowindow.open(map, marker);
	        }
	      })(marker, i));
	       marker.addListener('click', function() {
	           console.log(this.title);
               selectedBikeSpot = this.title;
	         });
	    }

}
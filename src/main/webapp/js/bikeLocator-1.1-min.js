var x = document.getElementById("demo");
var lat=''; var long = '';
/*
*
* gets the current location of user
* @Param: position of user)
*
* */

function showPosition(position) {
	lat = position.coords.latitude;
	long = position.coords.longitude;
    getBikeSpots(lat, long);
}
/*
*
* Gets the Bike spots and prepares the json for the Map
* @Param: latitude, longitude
*
* */
function getBikeSpots(lat, long)
{
    $.ajax({
        type: 'GET',url: "getBikeSpots",dataType: "json",
        success: function (json){
        	var array = [];
        	var bikeSpot = [];
            for(var i=0; i<json.length;i++)
			{
                array.push({
                     "latitude" : json[i].latitude,
                     "longitude": json[i].longitude,
                     "name" :json[i].name
				 });
			}
            array.push(
                {
                    "latitude": lat,
                    "longitude": long,
                    "name": "Current Location"
                }
			)
            loadMap(array);
        },
        error: function (xhr) {
            alert("Error:" + "Ooooops! We're down. Come back again.");
        }
    });
}

/*
*
* Loads the map
* @Param: json(Bike spots received from database)
*
* */
function loadMap(json)
{
	console.log(json);
	var map = new google.maps.Map(document.getElementById('map'), {
	zoom: 14,
	center: new google.maps.LatLng(52.674492,-8.5737320),
	mapTypeId: google.maps.MapTypeId.ROADMAP
	});
	var infowindow = new google.maps.InfoWindow();
	var marker, i;
	for (i = 0; i < json.length; i++)
	{
			if(i==(json.length-1))
	    	{
	    			marker = new google.maps.Marker({
					title: json[i].name,
	    	        position: new google.maps.LatLng(json[i].latitude, json[i].longitude),
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
                    title: json[i].name,
                    position: new google.maps.LatLng(json[i].latitude, json[i].longitude),
                    animation: google.maps.Animation.DROP,
	    	        map: map
	    	      });
	    		}

	      google.maps.event.addListener(marker, 'click', (function(marker, i) {
	        return function() {
	          infowindow.setContent(json[i].name);
	          infowindow.open(map, marker);
	        }
	      })(marker, i));
	       marker.addListener('click', function() {
	           console.log(this.title);
               selectedBikeSpot = this.title;
	         });
	    }

}
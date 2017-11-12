package entities.bike;

import lombok.Data;

@Data
public class Bike {

    // represents the bike's id
    String bikeID;
    // represents bike location;
    String bikeSpotLocation;
    // represents the bike availability
    String BikeStatus;
    //Bike Type
    String BikeType;

}

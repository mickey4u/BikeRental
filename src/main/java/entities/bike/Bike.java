package entities.bike;

import lombok.Data;

/**
 * Represents a bike
 */
@Data
public class Bike {
    // bike's id
    private String bikeId;
    // location of the bike
    private BikeLocation location;
    // spot where the bike is located
    private String bikeSpot;
    // type of bike
    private BikeType bikeType;
    // bike state
    private BikeStatus bikeStatus;
    // deleted status
    private boolean deleted;
    //Actual Rate/Hr
    private String rate;
}

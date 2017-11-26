package entities.bike;

import lombok.Data;

import java.util.Optional;

/**
 * Represents a bike
 */
@Data
public class Bike {
    // bike's id
    private Optional<String> bikeId;
    // location of the bike
    private BikeLocation location;
    // spot where the bike is located
    private Optional<String> bikeSpot;
    // type of bike
    private BikeType bikeType;
    // bike state
    private BikeStatus bikeStatus;
    // bike available
    private boolean bikeAvailable;
}

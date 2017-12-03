package models.bikespotmodel;

import entities.bikeSpot.BikeSpots;

import java.util.List;

public interface IBikeSpotModel {
    /**
     * Retrieves a list of bike spots
     *
     * @return list of bike spots
     */
    List<BikeSpots> getBikeSpots();
}

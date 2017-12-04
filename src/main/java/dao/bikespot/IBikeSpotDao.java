package dao.bikespot;

import entities.bikeSpot.BikeSpots;

import java.util.List;

public interface IBikeSpotDao {
    /**
     * Connects with Database to fetch the records of the Bikespots
     *
     * @return
     */
    List<BikeSpots> getBikeSpots();
}

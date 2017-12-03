package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BikeStatus;

import java.util.List;
import java.util.Optional;

/**
 * Bike Dao contract
 */
public interface IBikeDao {

    /**
     * Find a Bike from the database wrt The Bike Spots
     *
     * @param bikeSpot name of the bike spot
     * @return return available Bikes if found and null if it doesn't not exist
     */
    List<Bike> getAvailableBikesBySpot(String bikeSpot);

    /**
     * Retrieves only registered bikes
     *
     * @return
     */
    List<Bike> getAllBikes();


    /**
     * Retrieves all unregistered bikes
     *
     * @return
     */
    List<Bike> getAllDeletedBikes();

    /**
     * Retrieves a particular bike from the database
     *
     * @param bikeId
     * @return
     */
    Optional<Bike> findBikeById(String bikeId);

    /**
     * Adds a new bike to the system
     *
     * @param bike
     * @return
     */
    boolean registerBike(Bike bike);

    /**
     * deletes bike from the bike rental system, soft delete
     *
     * @param bikeId
     * @return
     */
    boolean deleteBikeById(String bikeId);

    /**
     * Changes the state of the bike
     *
     * @param bikeId
     * @param bikeStatus
     * @return
     */
    boolean updateBikeStatus(String bikeId, BikeStatus bikeStatus);

    /**
     * Retrieve a list of bikes based on a bike status
     *
     * @param bikeStatus
     * @return list of bikes
     */
    List<Bike> getAllBikes(BikeStatus bikeStatus);
}

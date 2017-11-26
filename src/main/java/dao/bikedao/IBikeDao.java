package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BookingType;

import java.util.List;

/**
 * Bike Dao contract
 */
public interface IBikeDao {

    /**
     * Retrieves all bikes related to a particular bike spot
     *
     * @param bikeSpot name of the bike spot
     * @return a list of bikes located at this spot
     */
    List<Bike> getAvailableBikes(String bikeSpot);

    /**
     * Retrieves all bikes on the rental system
     *
     * @return list of bikes
     */
    List<Bike> getAllBikes();

    /**
     * Method handles booking of bikes on the platform
     *
     * @param userId      id of the user booking the bike
     * @param bookingType type of booking specified by the user
     * @return true if booking was successful
     */
    boolean bookBike(String userId, BookingType bookingType);

    boolean changeBikeStatus(String bikeId);

}

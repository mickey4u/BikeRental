package dao.bikedao;

import entities.bike.Bike;
import entities.bike.BookingType;
import lombok.AllArgsConstructor;

import java.util.List;

/**
 * User Data Access Object
 */
@AllArgsConstructor
public class BikesDao implements IBikeDao {
    private BikeAccess access;

    @Override
    public List<Bike> getAvailableBikes(String bikeSpot) {

        return access.availableBikes(bikeSpot);
    }

    @Override
    public List<Bike> getAllBikes() {
        return null;
    }

    @Override
    public boolean bookBike(String userId, BookingType bookingType) {
        return false;
    }

    @Override
    public boolean changeBikeStatus(String bikeId) {
        return false;
    }


}

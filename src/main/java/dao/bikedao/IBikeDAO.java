package dao.bikedao;

import entities.bike.Bike;

import java.util.List;

public interface IBikeDAO {

    List fetchAvailableBikes(String bikeSpot);

    List<Bike> fetchAllBikes();

    boolean rentNow(String bikeSpot, String bikeType, long time, String bookingID);

    Boolean updateBikeStatus(Bike rentBike);

    //Collection getBookingDetails(); //

}

package dao.bikedao;

import entities.bike.Bike;

import java.util.List;

public interface IBikeDAO {

    List fetchAvailableBikes(String bikeSpot);
    List<Bike> fetchAllBikes();

    boolean rentNow(String bikeSpots, String gear);
    Boolean updateBikeStatus(Bike rentBike);

    //Collection getBookingDetails(); //

}

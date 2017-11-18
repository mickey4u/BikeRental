package dao.bike;

import java.util.List;

public interface IBikeDAO {

    List fetchAvailableBikes(String bikeSpot);

    boolean rentNow(String bikeSpots, String gear);

    //Collection getBookingDetails(); //

}

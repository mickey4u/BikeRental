package dao.bikedao;

import java.util.List;

public interface IBikeDAO {

    List fetchAvailableBikes(String bikeSpot);

    boolean rentNow(String bikeSpots, String gear);

    //Collection getBookingDetails(); //

}

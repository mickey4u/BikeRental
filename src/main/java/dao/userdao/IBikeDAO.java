package dao.userdao;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public interface IBikeDAO {

    List fetchAvailableBikes(String bikeSpot);

    //Collection getBookingDetails(); //

}

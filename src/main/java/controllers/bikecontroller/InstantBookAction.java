package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import lombok.Data;
import models.bikemodel.BikeFactory;
import models.bikemodel.IBook;

@Data
public class InstantBookAction extends ActionSupport {

    String bikeSpots;
    String bikeType;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * Responsibe for Instant Booking of the Bike
     * Fetches the list of Bikes For the Given BikeLocation
     * @return
     */
    public String instantBooking()
    {
        Boolean bookingStatus = false;

        BikeFactory bikeFactory = new BikeFactory();

        IBook bike = bikeFactory.bikeType(bikeType);

        if(bikeType.equalsIgnoreCase("gearBike"))
        {
            bikeRentalSingleton.getGearBike().rentBike(bikeSpots);
        }
        else
        {
            bikeRentalSingleton.getCityBike().rentBike(bikeSpots);
        }

        return SUCCESS;
    }
}

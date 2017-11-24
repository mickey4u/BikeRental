package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Bike;
import lombok.Data;
import models.bikemodel.IBike;

import java.util.List;

/**
 *
 */
@Data
public class BikesAction extends ActionSupport {
    String bikeSpotLocation="";
    private IBike ibike;
    private Bike bike;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();

    /**
     * Availability of Bikes
     * @return List of Available Bikes
     */
    public String checkAvailableBikes() {
        String bikeSpot = bikeSpotLocation;
        List<Bike> bikeSpots = bikeRentalSingleton.getBikeModel().checkAvailableBikes(bikeSpot);
        return SUCCESS;
    }

    public Boolean addServicedBikes(){
        ibike.addNewServicedBike(bike);
        return true;
    }

}

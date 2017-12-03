package controllers.bikeSpot;

import com.opensymphony.xwork2.ActionSupport;
import entities.bikeSpot.BikeSpots;

import java.util.List;

/**
 * This Action returns the List of Bike Spots
 */
public class DashboardBikeSpotsAction extends ActionSupport {

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    List<BikeSpots> bikeSpots;

    /**
     * Method mapped with struts.xml to Dipslay the Bikespots
     * @return bikeSpots
     * @throws Exception
     */
    @Override
    public String execute() throws Exception {
        bikeSpots = bikeRentalSingleton.getBikeSpotModel().getBikeSpots();
        return SUCCESS;
    }

    public List<BikeSpots> getBikeSpots() {
        return bikeSpots;
    }

    public void setBikeSpots(List<BikeSpots> bikeSpots) {
        this.bikeSpots = bikeSpots;
    }
}

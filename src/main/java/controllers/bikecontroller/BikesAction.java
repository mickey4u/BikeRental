package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Bike;

import java.util.List;

/**
 *
 */
public class BikesAction extends ActionSupport {
    String bikeSpotLocation;
    private Bike bike;
    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();
    List<Bike> bikeSpots;

    public String execute() {
        bikeSpots = bikeRentalSingleton.getBikeModel().getAvailableBikesBySpot(bikeSpotLocation);
        return SUCCESS;
    }

    public Boolean addServicedBikes(){
        // ibike.addNewServicedBike(bike);
        return true;
    }

    public String getBikeSpotLocation() {
        return bikeSpotLocation;
    }

    public void setBikeSpotLocation(String bikeSpotLocation) {
        this.bikeSpotLocation = bikeSpotLocation;
    }

    public Bike getBike() {
        return bike;
    }

    public void setBike(Bike bike) {
        this.bike = bike;
    }

    public List<Bike> getBikeSpots() {
        return bikeSpots;
    }

    public void setBikeSpots(List<Bike> bikeSpots) {
        this.bikeSpots = bikeSpots;
    }

}

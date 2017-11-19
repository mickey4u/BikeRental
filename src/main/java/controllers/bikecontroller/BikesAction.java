package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Bike;
import models.bikemodel.IBike;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 */
public class BikesAction extends ActionSupport {
    models.bikemodel.IBike bikespots;
    @Getter
    @Setter
    String bikeSpot;
    String bikeID;
    IBike AdminsterAddServicedBike;
    Bike  servicedBike;
    /**
     * @return
     */
    public String checkAvailableBikes() {
        List<Bike> bikeSpots = bikespots.checkAvailableBikes(bikeSpot);
        return SUCCESS;
    }
    public Boolean addServicedBikes(){
        AdminsterAddServicedBike.addNewServicedBike(servicedBike);
        return true;
    }

}

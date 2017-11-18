package controllers.bikecontroller;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Bike;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 *
 */
public class BikesAction extends ActionSupport {
    models.bikemodel.Bike.IBike bikespots;
    @Getter
    @Setter
    String bikeSpot;


    /**
     * @return
     */
    public String checkAvailableBikes() {
        List<Bike> bikeSpots = bikespots.checkAvailableBikes(bikeSpot);
        return SUCCESS;
    }

}

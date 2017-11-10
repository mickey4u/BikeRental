package controllers.bike;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.Bike;
import lombok.Getter;
import lombok.Setter;
import models.IBike;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 */
public class BikesAction extends ActionSupport {
    IBike bikespots;
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

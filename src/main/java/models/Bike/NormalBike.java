package models.Bike;

import dao.userdao.IBikeDAO;
import models.Bike.Bike;

import java.util.List;

public class NormalBike implements Bike {

    IBikeDAO bike;

    public NormalBike(String bikeSpots)
    {
        rentBike(bikeSpots);
    }

    @Override
    public boolean rentBike(String bikeSpots) {
        List<entities.bike.Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        if(AvailableBikes.size()>0)
        {
            //bookings.json updated with booking ID
            //BikeSpots.json updated with changed biked status
            return true;
        }
        return false;
    }

    public List<entities.bike.Bike> checkAvailableBikes(String bikeSpot)
    {
        List<entities.bike.Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }
}

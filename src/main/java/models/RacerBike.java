package models;

import dao.userdao.IBikeDAO;

import java.util.List;

public class RacerBike implements Bike {

    double charges = 1.0;
    IBikeDAO bike;
    public RacerBike(String bikeSpots)
    {

        List<entities.bike.Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        if(AvailableBikes.size()>0)
        {
            //bookings.json updated with booking ID
            //BikeSpots.json updated with changed biked status
            /*return true;*/
        }
        else
        {
           /* return false;*/
        }
    }

    public List<entities.bike.Bike> checkAvailableBikes(String bikeSpot)
    {
        List<entities.bike.Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }

    @Override
    public boolean rentBike() {
        return false;
    }
}

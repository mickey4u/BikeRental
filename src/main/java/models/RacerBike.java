package models;

import java.util.List;

public class RacerBike implements Bike {
    @Override
    public boolean rentBike()
    {
        List<entities.bike.Bike> AvailableBikes = checkAvailableBikes(bikeSpot);
        if(AvailableBikes.size()>0)
        {
            //bookings.json updated with booking ID
            //BikeSpots.json updated with changed biked status
            return true;
        }
        else
        {
            return false;
        }
    }

    public List<entities.bike.Bike> checkAvailableBikes(String bikeSpot)
    {
        List<entities.bike.Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }
}

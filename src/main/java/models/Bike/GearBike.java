package models.Bike;

import dao.userdao.IBikeDAO;

import java.util.List;

public class GearBike implements Bike {

    IBikeDAO bike;

    public GearBike(String bikeSpots)
    {
        rentBike(bikeSpots);
    }

    public boolean rentBike(String bikeSpots)
    {
        List<entities.bike.Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        boolean booking = false;
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,"gear");
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

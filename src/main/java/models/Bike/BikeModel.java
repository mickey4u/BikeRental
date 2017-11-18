package models.bike;

import dao.bike.BikesDao;
import entities.bike.Bike;

import java.util.List;


public class BikeModel implements models.bike.Bike.IBike {

    private BikesDao bike;

    public List<Bike> checkAvailableBikes(String bikeSpot)
    {
        List<Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }

    public Boolean bikeBook(String bikeSpot){
        List<Bike> AvailableBikes = checkAvailableBikes(bikeSpot);
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

}

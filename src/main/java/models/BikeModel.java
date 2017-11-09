package models;
import dao.userdao.BikesDao;
import entities.bike.Bike;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class BikeModel implements IBike {

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

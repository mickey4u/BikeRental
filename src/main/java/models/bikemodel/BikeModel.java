package models.bikemodel;

import dao.bikedao.BikesDao;
import entities.bike.Bike;

import java.util.List;


public class BikeModel implements IBike {

    private BikesDao bike;

    public BikeModel(BikesDao bikesDao) {
        this.bike = bikesDao;
    }

    public List<Bike> checkAvailableBikes(String bikeSpot)
    {
        List<Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }

    @Override
    public Boolean addNewServicedBike(Bike ServicedBike) {
        return null;
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

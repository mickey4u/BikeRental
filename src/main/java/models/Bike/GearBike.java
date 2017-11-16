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
        BikeConstant bikeType = new BikeConstant();
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,bikeType.getGearBike());
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

package models.Bike;

import dao.userdao.IBikeDAO;

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
        BikeConstant bikeType = new BikeConstant();
        boolean booking = false;
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,bikeType.getCityBike());
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

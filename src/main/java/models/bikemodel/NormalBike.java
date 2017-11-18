package models.bikemodel;

import dao.bikedao.IBikeDAO;

import java.util.List;

public class NormalBike implements Bike {

    IBikeDAO bike;

    public NormalBike(String bikeSpots)
    {
        rentBike(bikeSpots);
    }

    @Override
    public boolean rentBike(String bikeSpots) {
        List<Bike> AvailableBikes = checkAvailableBikes(bikeSpots);
        models.bikemodel.BikeConstant bikeType = new BikeConstant();
        boolean booking = false;
        if(AvailableBikes.size()>0)
        {
            booking = bike.rentNow(bikeSpots,bikeType.getCityBike());
            return true;
        }
        return false;
    }

    public List<Bike> checkAvailableBikes(String bikeSpot)
    {
        List<Bike> AvailableBikes = bike.fetchAvailableBikes(bikeSpot);
        return AvailableBikes;
    }
}

package models;

import entities.bike.Bike;

import java.util.List;

public class BikeFactory implements IBike {

    @Override
    public List<Bike> checkAvailableBikes(String bikeSpot) {
        return null;
    }

    @Override
    public models.Bike bikeBook(String bikeSpots, String bikeType) {

        if(bikeType=="racerBike")
        {
            return new RacerBike();
        }
        if(bikeType=="normalBike")
        {
            return new NormalBike();
        }
        return null;
    }
}

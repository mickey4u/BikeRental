package models;

import entities.bike.Bike;

import java.util.List;

public class BikeFactory{

    public List<Bike> checkAvailableBikes(String bikeSpot) {
        return null;
    }

    public models.Bike bikeBook(String bikeSpots, String bikeType) {

        if(bikeType=="racerBike")
        {
            return new RacerBike(bikeSpots);
        }
        if(bikeType=="normalBike")
        {
            return new NormalBike(bikeSpots);
        }
        return null;
    }
}

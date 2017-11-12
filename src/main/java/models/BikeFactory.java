package models;

import entities.bike.Bike;

import java.util.List;

public class BikeFactory{

    public List<Bike> checkAvailableBikes(String bikeSpot) {
        return null;
    }

    public models.Bike bikeBook(String bikeSpots, String bikeType) {

        if(bikeType=="CityBike")
        {
            return new RacerBike(bikeSpots);
        }
        if(bikeType=="GearBike")
        {
            return new NormalBike(bikeSpots);
        }
        return null;
    }
}

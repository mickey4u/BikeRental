package models;

import entities.bike.Bike;

import java.util.List;

public interface IBike {

    public List<Bike> checkAvailableBikes(String bikeSpot);
    public models.Bike bikeBook(String bikeSpots, String BikeType);

}

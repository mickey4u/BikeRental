package models.bikemodel;

import entities.bike.Bike;

import java.util.List;

/**
 *
 */
public interface IBike {

    /*Adds serviced Bikes*/
    Boolean addNewServicedBike(Bike ServicedBike);

    /*Books Available Bikes*/
    Boolean bikeBook(String bikeSpots);

    /*Find Available Bikes*/
    List<Bike> checkAvailableBikes(String bikeSpot);
}
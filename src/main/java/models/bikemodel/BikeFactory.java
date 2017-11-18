package models.bikemodel;

public class BikeFactory {

    /*
    * Factory Pattern for the user to book Bikes based bikeTypes
    * paramters:
    * bikeSpots : location for which the bike is booked
    * bikeType: The type of bike which needs to be booked.
    *
    * */
    public Bike bikeBook(String bikeSpots, String bikeType) {
        boolean result = false;
        BikeConstant type = new BikeConstant();
        if (bikeType.equals(type.getCityBike())) {
            return new NormalBike(bikeSpots);
        }
        if (bikeType.equals(type.getGearBike())) {
            return new GearBike(bikeSpots);
        }
        return null;
    }
}

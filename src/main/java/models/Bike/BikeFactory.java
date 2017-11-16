package models.Bike;

public class BikeFactory{

    //public List<Bike> checkAvailableBikes(String bikeSpot) {
      //  return null;
    //}

        /*
        * Factory Pattern for the user to book Bikes based bikeTypes
        * paramters:
        * bikeSpots : location for which the bike is booked
        * bikeType: The type of bike which needs to be booked.
        *
        * */
    public Bike bikeBook(String bikeSpots, String bikeType) {
        boolean result = false;
        if(bikeType=="CityBike")
        {
           return new NormalBike(bikeSpots);
        }
        if(bikeType=="GearBike")
        {
            return new GearBike(bikeSpots);
        }
        return null;
    }
}

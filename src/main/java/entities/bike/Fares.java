package entities.bike;

public class Fares {

    public static Double bikeRate(BikeType bikeType)
    {
        switch (bikeType) {
            case CityBike: return 1.0;  //1 Euro
            case GearBike: return 2.0;  //2 Euro
            default:
                return 0.0;
        }
    }
}

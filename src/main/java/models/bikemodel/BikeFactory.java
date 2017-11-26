package models.bikemodel;

public class BikeFactory {

    public IBook bikeType(String bikeType) {

        boolean result = false;
        BikeConstant type = new BikeConstant();
        if (bikeType.equals(type.getCityBike())) {
            return new NormalBike(bikeType);
        }
        if (bikeType.equals(type.getGearBike())) {
            return new GearBike(bikeType);
        }
        return null;

    }
}

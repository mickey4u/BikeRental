package entities.bike;

/**
 * This class holds the bicycles location coordinates
 */
public class BikeLocation {

    // longitude value of the coordinate
    private long longitude;
    // latitude value of the coordinate
    private long latitude;

    public long getLongitude() {
        return longitude;
    }

    public void setLongitude(long longitude) {
        this.longitude = longitude;
    }

    public long getLatitude() {
        return latitude;
    }

    public void setLatitude(long latitude) {
        this.latitude = latitude;
    }
}

package entities.bike;

import lombok.Data;

@Data
public class ActiveBooking {

    String bikeID;
    String bookingTime;
    String bikeSpots;
    String bookingID;
}

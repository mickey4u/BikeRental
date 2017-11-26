package entities.bike;

import lombok.Data;

import java.util.Optional;

/**
 * Represents a booking for a bike
 */
@Data
public class Booking {
    // booking id
    private Optional<String> bookingId;
    // represents id of the bike that was booked
    private Optional<String> bikeId;
    // the spot from which the bike was taken from
    private Optional<String> bikeSpot;
    // type of booking
    private BookingType bookingType;
    // status of the booking, whether the booking was cancelled
    private boolean status;
}

package entities.bike;

import java.util.Optional;

/**
 * Represents a booking for a bike
 */
public class Booking {

    public Optional<String> getBookingId() {
        return bookingId;
    }

    public void setBookingId(Optional<String> bookingId) {
        this.bookingId = bookingId;
    }

    public Optional<String> getBikeId() {
        return bikeId;
    }

    public void setBikeId(Optional<String> bikeId) {
        this.bikeId = bikeId;
    }

    public Optional<String> getBikeSpot() {
        return bikeSpot;
    }

    public void setBikeSpot(Optional<String> bikeSpot) {
        this.bikeSpot = bikeSpot;
    }

    public BookingType getBookingType() {
        return bookingType;
    }

    public void setBookingType(BookingType bookingType) {
        this.bookingType = bookingType;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

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

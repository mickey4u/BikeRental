package interceptors.perevent;


import entities.booking.Booking;

public class BookingRequest implements IBookingRequest {

    // store booking details
    private Booking booking;

    @Override
    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    @Override
    public Booking getBooking() {
        return booking;
    }
}

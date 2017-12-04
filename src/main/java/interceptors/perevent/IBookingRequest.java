package interceptors.perevent;

import entities.booking.Booking;

/**
 * Context object [Booking]
 */
public interface IBookingRequest {

    /**
     * Sets booking details
     *
     * @param booking booking details
     */
    void setBooking(Booking booking);

    /**
     * Get the details from the booking context object
     *
     * @return the booking details
     */
    Booking getBooking();
}

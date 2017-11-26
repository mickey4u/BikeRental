package models.rentalmodel;

import entities.bike.Booking;

import java.util.List;

/**
 * Book model contract
 */
public interface IBookModel {

    /**
     * Creates a bike booking
     *
     * @param booking
     * @return
     */
    boolean bookBike(Booking booking);

    /**
     * Cancels a booking
     *
     * @param bookingId id of the booking to be cancelled
     * @return
     */
    boolean cancelBooking(String bookingId);

    /**
     * Retrieves all active bookings
     *
     * @return list of active bookings on the system
     */
    List<Booking> getAllBookings();
}

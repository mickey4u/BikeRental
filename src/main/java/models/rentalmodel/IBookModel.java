package models.rentalmodel;

import entities.booking.Booking;

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

    /**
     * Set the time the bike was unlocked from the spot
     *
     * @param bookingId
     * @return
     */
    boolean startRentalTime(String bookingId);

    /**
     * Set the time the bike was returned to the spot
     *
     * @param bookingId
     * @return
     */
    boolean endRentalTime(String bookingId);
}

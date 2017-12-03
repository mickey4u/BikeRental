package dao.bookingdao;

import entities.booking.Booking;

import java.util.List;

/**
 * Book Dao contract
 */
public interface IBookDao {

    /**
     * Checks if the booking with this id already exist in the database
     *
     * @param bookingId
     * @return
     */
    boolean checkExist(String bookingId);

    /**
     * Retrieve a booking from the database
     *
     * @param bookingId
     * @return
     */
    Booking findBookingById(String bookingId);

    /**
     * Creates a booking
     *
     * @param booking
     * @return
     */
    boolean insertBooking(Booking booking);

    /**
     * Cancels a booking
     *
     * @param bookingId id of the booking to be cancelled
     * @return
     */
    boolean cancelBooking(String bookingId);

    /**
     * Set start time for the bike usage
     *
     * @param bookingId
     * @return
     */
    boolean startRentalTime(String bookingId);

    /**
     * Set time when the bike was returned
     *
     * @param bookingId
     * @return
     */
    boolean endRentalTime(String bookingId);

    /**
     * Retrieves all active bookings
     *
     * @return list of active bookings on the system
     */
    List<Booking> getAllBookings();
}

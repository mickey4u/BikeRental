package dao.bookingdao;

import entities.bike.Booking;

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
     * Retrieves all active bookings
     *
     * @return list of active bookings on the system
     */
    List<Booking> getAllBookings();
}
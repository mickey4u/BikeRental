package dao.bookingdao;

import entities.bike.Booking;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;

import java.util.List;

/**
 * Used for bookings table access in the database
 */
public interface BookAccess {

    /**
     * Checks if the booking with this id already exist in the database
     *
     * @param bookingId
     * @return
     */
    @SqlQuery("select count(1) from BOOKINGS where booking_id = :bookingId")
    boolean checkExist(@Bind("bookingId") String bookingId);

    /**
     * Creates a booking
     *
     * @param booking
     * @return
     */
    @SqlUpdate("insert into BOOKINGS(booking_id, bike_id, bike_spot, booking_type, status) values " +
            "(:bookingId, :bikeId, :bikeSpot, :bookingType, :status)")
    boolean insertBooking(@BindBean Booking booking);

    /**
     * Cancels a booking
     *
     * @param bookingId id of the booking to be cancelled
     * @return
     */
    @SqlUpdate("update BOOKINGS set cancelled = true where booking_id = :bookingId")
    boolean cancelBooking(@Bind("bookingId") String bookingId);

    /**
     * Retrieves all active bookings
     *
     * @return list of active bookings on the system
     */
    @SqlQuery("select * from BOOKINGS where status = false")
    List<Booking> getAllBookings();
}

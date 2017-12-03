package dao.bookingdao;

import entities.booking.Booking;
import entities.booking.BookingMapper;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.customizer.BindBean;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Timestamp;
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
     * Retrieve a booking from the database
     *
     * @param bookingId
     * @return
     */
    @SqlQuery("select * from BOOKINGS where booking_id = :bookingId")
    @UseRowMapper(BookingMapper.class)
    Booking findBookingById(@Bind("bookingId") String bookingId);

    /**
     * Creates a booking
     *
     * @param booking
     * @return
     */
    @SqlUpdate("insert into BOOKINGS(booking_id, bike_id, bike_spot, booking_type, status,username) values " +
            "(:bookingId, :bikeId, :bikeSpot, :bookingType, :status, :username)")
    boolean insertBooking(@BindBean Booking booking);

    /**
     * Cancels a booking
     *
     * @param bookingId id of the booking to be cancelled
     * @return
     */
    @SqlUpdate("update BOOKINGS set status = true where booking_id = :bookingId")
    boolean cancelBooking(@Bind("bookingId") String bookingId);

    /**
     * Set the time the bike was unlocked from the spot
     *
     * @param bookingId
     * @param startTime
     * @return
     */
    @SqlUpdate("update BOOKINGS set start_time = :startTime where booking_id = :bookingId")
    boolean startRentalTime(@Bind("bookingId") String bookingId, @Bind("startTime") Timestamp startTime);

    /**
     * Set the time the bike was returned to the spot
     *
     * @param bookingId
     * @param endTime
     * @return
     */
    @SqlUpdate("update BOOKINGS set end_time = :endTime where booking_id = :bookingId")
    boolean endRentalTime(@Bind("bookingId") String bookingId, @Bind("endTime") Timestamp endTime);

    /**
     * Retrieves all active bookings
     *
     * @return list of active bookings on the system
     */
    @SqlQuery("select * from BOOKINGS where status = false")
    List<Booking> getAllBookings();
}

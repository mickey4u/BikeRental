package dao.bookingdao;

import entities.bike.Booking;
import entities.bike.BookingType;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Booking mapper for result set from database
 */
public class BookingMapper implements RowMapper<Booking> {
    @Override
    public Booking map(ResultSet rs, StatementContext ctx) throws SQLException {

        Booking booking = new Booking();
        booking.setBookingId(rs.getString("booking_id"));
        booking.setBikeId(rs.getString("bike_id"));
        booking.setStatus(rs.getBoolean("booking_status"));
        booking.setBikeSpot(rs.getString("bike_spot"));
        booking.setBookingType(BookingType.valueOf(rs.getString("booking_type")));

        return booking;
    }
}

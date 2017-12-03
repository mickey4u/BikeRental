package entities.booking;

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
        booking.setUsername(rs.getString("username"));
        booking.setStatus(rs.getBoolean("status"));
        booking.setBikeSpot(rs.getString("bike_spot"));
        booking.setBookingType(BookingType.valueOf(rs.getString("booking_type")));
        booking.setStartTime(rs.getTimestamp("start_time"));
        booking.setEndTime(rs.getTimestamp("end_time"));

        return booking;
    }
}

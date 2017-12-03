package dao.userdao;


import entities.booking.Booking;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RentalHistoryMapper implements RowMapper<Booking> {
    @Override
    public Booking map(ResultSet rs, StatementContext ctx) throws SQLException {
        Booking booking = new Booking();
        booking.setBikeId(rs.getString("bike_id"));
        booking.setBikeSpot(rs.getString("bike_spot"));
        booking.setBookingId(rs.getString("booking_id"));
        return booking;
    }
}

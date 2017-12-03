package dao.bookingdao;

import entities.bike.Booking;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

/**
 * Bookings Data Access Object
 */
@AllArgsConstructor
public class BookDao implements IBookDao {
    private final BookAccess access;

    @Override
    public boolean checkExist(String bookingId) {
        Optional.of(bookingId).orElseThrow(NullPointerException::new);
        return access.checkExist(bookingId);
    }

    @Override
    public boolean insertBooking(Booking booking) {
        Optional.of(booking).orElseThrow(NullPointerException::new);
        // check if booking already exist
        if (access.checkExist(booking.getBookingId())) {
            return false;
        }
        return access.insertBooking(booking);
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        Optional.of(bookingId).orElseThrow(NullPointerException::new);
        // check if booking exist
        if (Boolean.TRUE.equals(access.checkExist(bookingId))) {
            return access.cancelBooking(bookingId);
        }
        return false;
    }

    @Override
    public List<Booking> getAllBookings() {
        return access.getAllBookings();
    }
}

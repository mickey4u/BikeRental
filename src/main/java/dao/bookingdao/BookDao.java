package dao.bookingdao;

import entities.booking.Booking;
import lombok.AllArgsConstructor;
import org.joda.time.LocalDateTime;

import java.sql.Timestamp;
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
    public Booking findBookingById(String bookingId) {
        return access.findBookingById(bookingId);
    }

    @Override
    public boolean insertBooking(Booking booking) {
        Optional.of(booking).orElseThrow(NullPointerException::new);
        // check if booking already exist
        if (access.checkActiveBooking(booking.getUsername())) {
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
    public boolean startRentalTime(String bookingId) {

        Optional.of(bookingId).orElseThrow(NullPointerException::new);
        // check if booking already exist
        if (access.checkExist(bookingId)) {
            LocalDateTime now = LocalDateTime.now();
            access.startRentalTime(bookingId, new Timestamp(now.toDateTime().getMillis()));
            return true;
        }
        return false;
    }

    @Override
    public boolean endRentalTime(String bookingId) {
        Optional.of(bookingId).orElseThrow(NullPointerException::new);
        // check if booking already exist
        if (access.checkExist(bookingId)) {
            LocalDateTime now = LocalDateTime.now();
            access.endRentalTime(bookingId, new Timestamp(now.toDateTime().getMillis()));
            return true;
        }
        return false;
    }

    @Override
    public List<Booking> getAllBookings() {
        return access.getAllBookings();
    }
}

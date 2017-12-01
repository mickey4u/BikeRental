package models.rentalmodel;

import dao.bookingdao.IBookDao;
import entities.bike.Booking;
import utilities.Utils;

import java.util.List;


public class BookModel implements IBookModel {
    private IBookDao bookDao;
    Utils bookingUtility= new Utils();
    public BookModel(IBookDao bookDao) {
        this.bookDao = bookDao;
    }

    @Override
    public boolean bookBike(Booking booking) {
        booking.setBookingId(bookingUtility.createBookingID());
        return bookDao.insertBooking(booking);
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        return bookDao.cancelBooking(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookDao.getAllBookings();
    }
}

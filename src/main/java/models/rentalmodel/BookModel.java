package models.rentalmodel;

import dao.bookingdao.IBookDao;
import entities.bike.BikeStatus;
import entities.booking.Booking;
import models.bikemodel.IBikeModel;
import utilities.Utils;

import java.util.List;


public class BookModel implements IBookModel {
    private IBookDao bookDao;
    private IBikeModel bikeModel;
    private Utils bookingUtility;

    public BookModel(IBookDao bookDao, IBikeModel bikeModel) {
        this.bookDao = bookDao;
        this.bikeModel = bikeModel;
        bookingUtility = new Utils();
    }

    @Override
    public boolean bookBike(Booking booking) {
        booking.setBookingId(bookingUtility.createBookingID());
        if (bookDao.insertBooking(booking)) {
            // change status to booked
            bikeModel.updateBikeStatus(booking.getBikeId(), BikeStatus.BOOKED);
            return true;
        }
        return false;
    }

    @Override
    public boolean cancelBooking(String bookingId) {
        return bookDao.cancelBooking(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookDao.getAllBookings();
    }

    @Override
    public boolean startRentalTime(String bookingId) {
        if (bookDao.startRentalTime(bookingId)) {
            // change status to in use
            Booking booking = bookDao.findBookingById(bookingId);
            bikeModel.updateBikeStatus(booking.getBikeId(), BikeStatus.IN_USE);
            return true;
        }
        return false;
    }

    @Override
    public boolean endRentalTime(String bookingId) {
        if (bookDao.endRentalTime(bookingId)) {
            // set bike to available available
            Booking booking = bookDao.findBookingById(bookingId);
            bikeModel.updateBikeStatus(booking.getBikeId(), BikeStatus.AVAILABLE);
            return true;
        }
        return false;
    }
}

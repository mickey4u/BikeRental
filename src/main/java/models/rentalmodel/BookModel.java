package models.rentalmodel;

import dao.bookingdao.IBookDao;
import dao.userdao.IUserDao;
import entities.bike.BikeStatus;
import entities.booking.Booking;
import entities.users.User;
import interceptors.LoggingDispatcher;
import interceptors.perevent.BookingRequest;
import interceptors.perevent.IBookingRequest;
import main.BikeRentalSingleton;
import models.bikemodel.IBikeModel;
import models.rentalmodel.notifications.BookingNotification;
import models.rentalmodel.notifications.Observer;
import models.rentalmodel.notifications.Subject;
import utilities.Utils;

import java.util.List;


public class BookModel implements IBookModel {
    private IBookDao bookDao;
    private IBikeModel bikeModel;
    private IUserDao userDao;
    private IBookingRequest bookingRequest;
    private Utils bookingUtility;

    public BookModel(IBookDao bookDao, IBikeModel bikeModel, IUserDao userDao) {
        this.bookDao = bookDao;
        this.bikeModel = bikeModel;
        this.userDao = userDao;
        bookingUtility = new Utils();
    }

    @Override
    public boolean bookBike(Booking booking) {
        String bookingId = bookingUtility.createBookingID();
        booking.setBookingId(bookingId);
        if (bookDao.insertBooking(booking)) {
            // change status to booked
            bikeModel.updateBikeStatus(booking.getBikeId(), BikeStatus.BOOKED);
            // send user booking notification
            Subject subject = BikeRentalSingleton.getInstance().getSubject();
            // notification observer
            Observer bookingObserver = new BookingNotification("Booking Notifications");
            // attach observer to subject
            subject.attach(bookingObserver);
            // send notification to user for booking
            User renter = userDao.findUserById(booking.getUsername());
            subject.sendNotifications("Dear " + renter.getFirstname() + " " +
                    "You have successfully booked a  bike." +
                    '\n' + "Your booking ID is : " + bookingId);

            // booking context object
            bookingRequest = new BookingRequest();
            bookingRequest.setBooking(booking);
            // pass the context object to teh dispatcher
            LoggingDispatcher.getInstance().dispatchClientPreRequestPreMarshal(bookingRequest);

            return true;
        }
        // booking context object
        bookingRequest = new BookingRequest();
        bookingRequest.setBooking(booking);
        System.err.println("------>Called");
        // pass the context object to teh dispatcher
        LoggingDispatcher.getInstance().dispatchClientPreRequestPreMarshal(bookingRequest);
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

package interceptors.perevent;

import entities.booking.Booking;
import utilities.FileManager;

/**
 * Concrete interceptor for logging bike bookings
 */
public class ClientBookingLoggerInterceptor implements IClientBookingInterceptor {

    @Override
    public void onPreBookingRequest(IBookingRequest context) {
        Booking booking = context.getBooking();
        FileManager.writeToFile(FileManager.BOOKINGS_lOG_FILE.getAbsolutePath(), booking);
    }

    @Override
    public void onPostBookingRequest(IBookingRequest context) {
        Booking booking = context.getBooking();
        String logMessage = "Booking with ID : " + booking.getBookingId() + " started at : "
                + booking.getStartTime();
        FileManager.writeToFile(FileManager.AFTER_BOOKINGS_lOG_FILE.getAbsolutePath(), logMessage);
    }
}

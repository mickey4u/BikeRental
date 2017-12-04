package interceptors.perevent;

import entities.booking.Booking;
import interceptors.MarshaledRequest;
import utilities.FileManager;

/**
 * Concrete interceptor for logging bike bookings
 */
public class ClientBookingLoggerInterceptor implements IClientBookingInterceptor {

    @Override
    public void onPreBookingRequest(IBookingRequest context) {
        System.err.println("------------->" + context.getBooking().toString());
        Booking booking = context.getBooking();
        FileManager.writeToFile(FileManager.BOOKINGS_lOG_FILE.getAbsolutePath(), booking);
    }

    @Override
    public void onPostBookingRequest(MarshaledRequest context) {

    }
}

package entities.bike;

import java.util.Date;
import java.util.UUID;

public class BookingUtils {

    public String createBookingID() {
        return UUID.randomUUID().toString();
    }

    public long getTime() {
        Date date = new Date();
        long time = date.getTime();
        return time;
    }
}

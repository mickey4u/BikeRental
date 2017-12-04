package utilities;

import org.javamoney.moneta.Money;

import java.io.File;

public interface Constants {

    Money CHARGE_PER_HOUR = Money.from(Money.of(2, "EUR"));
    String LOGGED_IN_USER = "loggedIn";
    String FILE_ENCODING = "UTF-8";
    String FILE_LOCATION = "/files/";

    String WORKING_DIRECTORY = System.getProperty("user.dir");
    File BOOKINGS_lOG_FILE = new File(WORKING_DIRECTORY + "\\Bookings.txt");
    File AFTER_BOOKINGS_lOG_FILE = new File(WORKING_DIRECTORY + "\\AfterBookings.txt");
}

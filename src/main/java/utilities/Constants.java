package utilities;

import org.javamoney.moneta.Money;

public interface Constants {

    Money CHARGE_PER_HOUR = Money.from(Money.of(2,"EUR"));
    String LOGGED_IN_USER = "loggedIn";
    String FILE_ENCODING = "UTF-8";
    String FILE_LOCATION = "/files/";
}

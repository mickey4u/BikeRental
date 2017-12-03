package entities.users;

import lombok.Data;

/**
 * Represents a user on the platform
 */
@Data
public class User {
    private UserRole role;
    // user's username, UL username number
    private String username;
    // user's password
    private String password;
    // user's first name
    private String firstname;
    // user's last name
    private String lastname;
    // user's phone number
    private String phoneNumber;
    // secret question
    private String secretQuestion;
    // answer to secret question
    private String secretAnswer;
    // user house address
    private Address address;
    // total number of bookings
    private int numberOfBookings;
    // user's ranking
    private UserRank userRank;
}

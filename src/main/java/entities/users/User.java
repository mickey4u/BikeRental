package entities.users;

import lombok.Data;

/**
 * Represents a user on the platform
 */
@Data
public class User {
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
}

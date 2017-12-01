package entities.users;

import lombok.Data;

import java.util.Optional;

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
    private Optional<String> firstname;
    // user's last name
    private Optional<String> lastname;
    // user's phone number
    private Optional<String> phoneNumber;
    // secret question
    private Optional<String> secretQuestion;
    // answer to secret question
    private Optional<String> secretAnswer;
    // user house address
    private Address address;
    // user's ranking
    private UserRank userRank;
}

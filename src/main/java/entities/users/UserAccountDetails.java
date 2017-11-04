package entities.users;

import java.util.List;
import java.util.Optional;

/**
 * Class represents required account details by either a bike renter
 * or bike owner
 */
public abstract class UserAccountDetails {

    // user's first name
    private Optional<String> firstName;
    // user's last name
    private Optional<String> lastName;
    // user's id, UL id number
    private Optional<String> id;
    // user's password
    private Optional<String> password;
    // secret question
    private Optional<String> secretQuestion;
    /* represents user roles configured for this user.
       either a bike owner, bike renter or both
    */
    private List<Enum> userRoles;

    public Optional<String> getFirstName() {
        return firstName;
    }

    public void setFirstName(Optional<String> firstName) {
        this.firstName = firstName;
    }

    public Optional<String> getLastName() {
        return lastName;
    }

    public void setLastName(Optional<String> lastName) {
        this.lastName = lastName;
    }

    public Optional<String> getId() {
        return id;
    }

    public void setId(Optional<String> id) {
        this.id = id;
    }

    public Optional<String> getPassword() {
        return password;
    }

    public void setPassword(Optional<String> password) {
        this.password = password;
    }

    public List<Enum> getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(List<Enum> userRoles) {
        this.userRoles = userRoles;
    }

    public Optional<String> getSecretQuestion() {
        return secretQuestion;
    }

    public void setSecretQuestion(Optional<String> secretQuestion) {
        this.secretQuestion = secretQuestion;
    }
}

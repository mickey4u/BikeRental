package models.users;

/**
 *
 */
public class Admin extends UserDecorator {

    public Admin(IUser iUser) {
        super(iUser);
    }

    public void login(String userName, String password) {

    }

    public void createAccount() {

    }

    public void resetPassword(String email) {

    }
}

package models.users;

/**
 *
 */
public class BikeOwner extends UserDecorator {

    public BikeOwner(IUser iUser) {
        super(iUser);
    }

    public void login(String userName, String password) {

    }

    public void createAccount() {

    }

    public void resetPassword(String email) {

    }
}

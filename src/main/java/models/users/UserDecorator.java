package models.users;

/**
 *
 */
public abstract class UserDecorator implements IUser {

    protected IUser iUser;

    public UserDecorator(IUser iUser) {
        this.iUser = iUser;
    }

}

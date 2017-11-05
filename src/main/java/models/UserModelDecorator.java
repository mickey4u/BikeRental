package models;

public abstract class UserModelDecorator implements IUserModel {
    private IUserModel model;

    @Override
    public void register(String firstname, String lastname, String id, String password, String phoneNumber, String secretQuestion) {
        model.register(firstname, lastname, id, password, phoneNumber, secretQuestion);
    }

    @Override
    public boolean login(String userId, String userPassword) {
       return model.login(userId, userPassword);
    }

    @Override
    public void logout() {
        model.logout();
    }
}

package models;

import dao.userdao.UserDAO;
import entities.users.User;

/**
 * Handles all the business logic for user on the platform
 */
public class UserModel implements IUserModel {

    private UserDAO userDAO = new UserDAO();
    private User user;


    @Override
    public void register(String firstname, String lastname, String id, String password, String phoneNumber,
                         String secretQuestion) {

    }

    @Override
    public boolean login(String userId, String userPassword) {

        user = userDAO.findUser(userId);

        if (user != null && user.getUsername().equals(userId) && user.getPassword().equals(userPassword)) {
            return true;
        }
        return false;
    }


    @Override
    public void logout() {

    }

    @Override
    public void passwordReset(String secretAnswer) {

    }
}

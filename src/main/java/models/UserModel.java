package models;

import dao.userdao.UserDAO;
import entities.users.RentalHistory;
import entities.users.User;

import java.io.FileNotFoundException;
import java.util.List;

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
    public List<RentalHistory> viewRentalHistory(String username) {

        List<RentalHistory> viewRentalHistory = userDAO.viewRentalHistory(username);
        return viewRentalHistory;
    }

    /*This method gets the userID and updates the user Password
    *
    * True : Password Updated
    * False : Password Not updated due to incorrect Input
    *
    * */
    @Override
    public Boolean passwordReset(String userId, String answer, String newPassword) throws FileNotFoundException {

        /*Fetches the user details*/
        Boolean matched = userDAO.getUserDetails(userId);

        if (matched) {
            Boolean status = userDAO.updateDetails(newPassword);
            return true;
        }
        return false;
    }
}

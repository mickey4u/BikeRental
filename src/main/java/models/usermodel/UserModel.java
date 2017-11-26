package models.usermodel;

import com.opensymphony.xwork2.ActionContext;
import dao.userdao.UserDAO;
import entities.users.RentalHistory;
import entities.users.User;
import utilities.Constants;

import java.io.FileNotFoundException;
import java.util.*;

/**
 * Handles all the business logic for user on the platform
 */
public class UserModel implements IUserModel, Constants {

    UserDAO userDAO;

    public UserModel(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean register(Optional<String> firstname, Optional<String> lastname, Optional<String> id,
                            Optional<String> password, Optional<String> phoneNumber, Optional<String> secretQuestion,
                            Optional<String> secretAnswer) {

        User user = new User();
        user.setUsername(id);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhoneNumber(phoneNumber);
        user.setSecretQuestion(secretQuestion);
        user.setSecretAnswer(secretAnswer);

        return userDAO.registerUser(user);
    }

    @Override
    public boolean login(Optional<String> userId, Optional<String> userPassword) {

        User user = userDAO.findUser(userId.toString());
        if (user != null && user.getUsername().equals(userId) && user.getPassword().equals(userPassword)) {
            return true;
        }
        return false;
    }


    @Override
    public void logout() {
        Map session = ActionContext.getContext().getSession();
        session.remove(LOGGED_IN_USER);
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
        try {
            Boolean matched = userDAO.getUserDetails(userId);
            if (matched) {
                Boolean status = userDAO.updateDetails(newPassword);
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}

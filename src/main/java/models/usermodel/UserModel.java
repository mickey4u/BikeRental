package models.usermodel;

import com.opensymphony.xwork2.ActionContext;
import dao.userdao.IUserDao;
import entities.booking.Booking;
import entities.users.User;
import entities.users.UserRank;
import utilities.Constants;

import java.util.List;
import java.util.Map;

/**
 * Handles all the business logic for user on the platform
 */
public class UserModel implements IUserModel, Constants {
    private IUserDao userDAO;
    public UserModel(IUserDao userDAO) {
        this.userDAO = userDAO;
    }

    @Override
    public boolean register(String firstname, String lastname, String id,
                            String password, String phoneNumber, String secretQuestion,
                            String secretAnswer) {

        User user = new User();
        user.setUsername(id);
        user.setPassword(password);
        user.setFirstname(firstname);
        user.setLastname(lastname);
        user.setPhoneNumber(phoneNumber);
        user.setSecretQuestion(secretQuestion);
        user.setSecretAnswer(secretAnswer);
        user.setUserRank(UserRank.BASIC);
       // userDAO=userDAOFactory.getUserDAO(Database.SQL);

        return userDAO.createUser(user);
    }

    @Override
    public boolean login(String userId, String userPassword) {

        User user = userDAO.findUserById(userId);
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
    public List<Booking> viewRentalHistory(String username) {
        return userDAO.getUserRentalHistory(username);
    }


    @Override
    public Boolean passwordReset(String userId, String answer, String newPassword) {

        return false;
    }

}

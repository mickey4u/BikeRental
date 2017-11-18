package controllers.user;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.users.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.SessionAware;
import utilities.Constants;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Handles user login
 */
public class LoginAction extends ActionSupport implements Constants, SessionAware, ModelDriven<User> {
    private static final Logger logger = LogManager.getLogger(LoginAction.class);

    private static final long serialVersionUID = 1L;
    private Map<String, Object> session = null;
    private User user = new User();

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();


    @Override
    public String execute() throws Exception {
        // check for user session existence
        HttpSession currentSession = ServletActionContext.getRequest().getSession(true);
        // cast object to user object
        User getSessionAttr = (User) currentSession.getAttribute(LOGGED_IN_USER);

        String action = null;

        if (getSessionAttr != null) {
            action = SUCCESS;
        } else if (user.getUsername() == null || user.getPassword() == null) {
            action = INPUT;

        } else if (user.getUsername().isEmpty() || user.getPassword().isEmpty()) {
            addActionError("Username/Password cannot be left blank");

        } else if (bikeRentalSingleton.getUserModel().login(user.getUsername(), user.getPassword())) {
            // store logged user in session
            session.put(LOGGED_IN_USER, user);
            action = SUCCESS;
        }

        return action;
    }

    @Override
    public void setSession(Map<String, Object> map) {
        this.session = map;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public User getModel() {
        return user;
    }

}

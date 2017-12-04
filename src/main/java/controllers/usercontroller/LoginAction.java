package controllers.usercontroller;

import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.ValidationAwareSupport;
import controllers.command.Command;
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
public class LoginAction implements Command, Constants, SessionAware, ModelDriven<User> {
    private static final Logger logger = LogManager.getLogger(LoginAction.class);
    private final ValidationAwareSupport validationAware = new ValidationAwareSupport();

    private static final long serialVersionUID = 1L;
    private Map<String, Object> session = null;
    private User user = new User();
    //IUnmarshaledRequest<User> userIUnmarshaledRequest = new UnmarshaledRequest();

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
        } else if (user.getUsername() == null || user.getUsername().trim().equals("")) {
            validationAware.addActionError("Username/Password cannot be left blank");

        } else if (user.getPassword() == null || user.getPassword().trim().equals("")) {
            validationAware.addActionError("Username/Password cannot be left blank");

        } else if (bikeRentalSingleton.getUserModel().login(user.getUsername(), user.getPassword())) {
            // store logged user in session
            session.put(LOGGED_IN_USER, user);
            action = SUCCESS;

           // userIUnmarshaledRequest.setObject(this.user);
            //LoggingDispatcher.getInstance().dispatchClientPreRequestPreMarshal(userIUnmarshaledRequest);
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

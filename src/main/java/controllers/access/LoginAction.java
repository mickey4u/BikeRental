package controllers.access;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.struts2.interceptor.SessionAware;
import utilities.Constants;

import java.util.Map;
import java.util.Optional;


public class LoginAction extends ActionSupport implements SessionAware, Constants, ModelDriven<User> {

    @Getter
    @Setter
    private User user;
    private Map<String, Object> userSession;
    private boolean loggedIn = false;

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();


    @Override
    public String execute() throws Exception {
            if (bikeRentalSingleton.getUserModel()
                    .login(user.getUsername(), user.getPassword())) {

                // store logged user in session
                userSession = ActionContext.getContext().getSession();
                userSession.put(LOGGED_IN_USER, user);
                loggedIn = true;

                return "dashboard";
            }


        return "login";
    }

    @Override
    public void setSession(Map<String, Object> userSession) {
        this.userSession = userSession;
    }

    @Override
    public User getModel() {
        return user;
    }
}

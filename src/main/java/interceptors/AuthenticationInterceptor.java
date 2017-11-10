package interceptors;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import entities.users.User;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import utilities.Constants;

import java.util.Map;

/**
 *
 */
public class AuthenticationInterceptor implements Interceptor, Constants {
    private static final Logger logger = LogManager.getLogger(AuthenticationInterceptor.class);

    public void destroy() {

    }


    public void init() {
        logger.info("Authentication Interceptor Initialized");
    }


    public String intercept(ActionInvocation actionInvocation) throws Exception {
        String actionToPerform = "";

        Map<String, Object> userSession = actionInvocation.getInvocationContext().getSession();
        // get user stored in the HTTP Session
        User user = (User) userSession.get(LOGGED_IN_USER);
        // user not logged in
        if (user == null) {
            actionToPerform = Action.LOGIN;
        } else {
            Action action = (Action) actionInvocation.getAction();
            if (action instanceof UserAware) {
                ((UserAware) action).setUser(user);
            }
            actionToPerform = actionInvocation.invoke();

        }
        return actionToPerform;
    }
}

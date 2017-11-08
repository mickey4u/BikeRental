package interceptors;


import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import controllers.access.LoginAction;
import controllers.access.UserAware;
import entities.users.User;
import org.apache.struts2.dispatcher.SessionMap;
import utilities.Constants;

import java.util.Map;

/**
 *
 */
public class AuthenticationInterceptor implements Interceptor, Constants {
    @Override
    public void destroy() {

    }

    @Override
    public void init() {

    }

    @Override
    public String intercept(ActionInvocation actionInvocation) throws Exception {
        ActionContext context = actionInvocation.getInvocationContext();
        if (context.getName().equalsIgnoreCase("login") ||
                context.getName().equalsIgnoreCase("login.action")) {

            return actionInvocation.invoke();
        }
        SessionMap<String, Object> map = (SessionMap<String, Object>) actionInvocation.getInvocationContext().getSession();
        if (map == null) {
            return "login";
        }
        Object user = map.get(LOGGED_IN_USER);
        if (user == null || user.equals("") || map.isEmpty() || map == null) {
            return "login";
        }

        return actionInvocation.invoke();

    }
}

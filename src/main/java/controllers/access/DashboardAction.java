package controllers.access;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.users.User;
import interceptors.UserAware;
import lombok.Getter;
import lombok.Setter;

public abstract class DashboardAction extends ActionSupport implements UserAware, ModelDriven<User> {
    @Getter
    @Setter
    private User user;

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return this.user;
    }

}

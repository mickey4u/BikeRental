package controllers.usercontroller;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import entities.users.RentalHistory;
import entities.users.User;
import interceptors.UserAware;
import lombok.Getter;
import lombok.Setter;
import models.usermodel.IUserModel;

import java.util.List;

public class DashboardAction extends ActionSupport implements UserAware, ModelDriven<User> {
    @Getter
    @Setter
    private User user;
    IUserModel iUserModel;

    public String viewRentalHistory()
    {
        List<RentalHistory> rentalHistory = iUserModel.viewRentalHistory(user.getUsername());  //UserID should go as Input
        return SUCCESS;
    }

    @Override
    public String execute() throws Exception {
        return SUCCESS;
    }

    @Override
    public User getModel() {
        return this.user;
    }

}

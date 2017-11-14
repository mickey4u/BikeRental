package controllers.bike;

import com.opensymphony.xwork2.ActionSupport;
import entities.users.RentalHistory;
import entities.users.User;
import models.Bike;
import models.IUserModel;

import java.util.ArrayList;
import java.util.List;

public class UsersAccountAction extends ActionSupport{

    IUserModel iUserModel;
    public String viewRentalHistory()
    {
        User user = new User();
        List<RentalHistory> rentalHistory = iUserModel.viewRentalHistory(user.getUsername());  //UserID should go as Input
        return SUCCESS;
    }


}

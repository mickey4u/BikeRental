package controllers.user;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.BikeType;
import models.IUserModel;

public class UserAction extends ActionSupport {


    String secretAnswer;
    String userId;
    String newPassword;
    IUserModel userPasswordReset;

    public String updatePassword()
    {

       Boolean status = userPasswordReset.passwordReset(userId,secretAnswer,newPassword);

       if(status)
            return SUCCESS;
        else
            return ERROR;
    }

}

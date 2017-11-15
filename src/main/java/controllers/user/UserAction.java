package controllers.user;

import com.opensymphony.xwork2.ActionSupport;
import entities.bike.BikeType;
import models.IUserModel;

import java.io.FileNotFoundException;

public class UserAction extends ActionSupport {


    String secretAnswer;
    String userId;
    String newPassword;
    IUserModel userPasswordReset;

    public String updatePassword()
    {

        Boolean status = null;
        try {
            status = userPasswordReset.passwordReset(userId,secretAnswer,newPassword);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if(status)
            return SUCCESS;
        else
            return ERROR;
    }

}

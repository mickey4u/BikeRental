package controllers.usercontroller;

import com.opensymphony.xwork2.ActionSupport;
import models.usermodel.IUserModel;

import java.io.FileNotFoundException;

public class ResetPasswordAction extends ActionSupport {
    String secretAnswer;
    String userId;
    String newPassword;
    IUserModel userPasswordReset;
    public String updatePassword() throws FileNotFoundException
    {
        Boolean status = null;
        status = userPasswordReset.passwordReset(userId,secretAnswer,newPassword);
        if(status)
            return SUCCESS;
        else
            return ERROR;
    }
}

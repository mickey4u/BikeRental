package actions;

import com.opensymphony.xwork2.ActionSupport;

public class UsersAction extends ActionSupport {

    /**
     *
     */
    private static final long serialVersionUID = -6275269125913784899L;
    String username;
    String password;

    main.BikeRentalSingleton bikeRentalSingleton = main.BikeRentalSingleton.getInstance();


    public String userLogin() {
        if (bikeRentalSingleton.getUserModel().login(username, password)) {
            return SUCCESS;
        }
        return SUCCESS;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public main.BikeRentalSingleton getBikeRentalSingleton() {
        return bikeRentalSingleton;
    }

    public void setBikeRentalSingleton(main.BikeRentalSingleton bikeRentalSingleton) {
        this.bikeRentalSingleton = bikeRentalSingleton;
    }

	/*
     * @SuppressWarnings("unused") public String resetPasswordRequest() { Boolean
	 * passwordUpdateStatus = iUserModel.requestPasswordChange(secretAnswer); return
	 * SUCCESS; }
	 * 
	 * public String resetPassword() { String passwordUpdateStatus =
	 * iUserModel.requestPasswordReset(newPassword, ID); return SUCCESS; }
	 * 
	 * public String getID() { return ID; }
	 * 
	 * 
	 * public void setID(String iD) { ID = iD; }
	 * 
	 * 
	 * public String getPwd() { return pwd; }
	 * 
	 * 
	 * public void setPwd(String pwd) { this.pwd = pwd; }
	 * 
	 * 
	 * public String getSecretAnswer() { return secretAnswer; }
	 * 
	 * public void setSecretAnswer(String secretAnswer) { this.secretAnswer =
	 * secretAnswer; }
	 * 
	 * public String getNewPassword() { return newPassword; }
	 * 
	 * public void setNewPassword(String newPassword) { this.newPassword =
	 * newPassword; }
	 */

}

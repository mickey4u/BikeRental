package models;

import dao.UserDAO;

/**
 * Handles all the business logic for user on the platform
 */
public class UserModel implements IUserModel {

	UserDAO userDAO = new UserDAO();

	/**
	 * Methods registers a user on the platform
	 *
	 * @param firstname
	 *            firstname of the user
	 * @param lastname
	 *            lastname of the user
	 * @param id
	 *            student/staff id of the user
	 * @param phoneNumber
	 *            phone number of the user
	 * @param secretQuestion
	 *            secret question of the user
	 */
	public void register(String firstname, String lastname, String id, String phoneNumber, String secretQuestion) {

		// check if the id of the user is a valid id for a UL student/staff
		// before continuing registration
		if (userDAO.userExist(id)) {

		} else {

		}

	}

	@Override
	public void register(String firstname, String lastname, String id, String password, String phoneNumber,
			String secretQuestion) {

	}

	
	@Override
	public boolean login(String userId, String userPassword) {

		// check if the id of the user is a valid id for a UL student/staff
		// before continuing registration
		if (userDAO.userExist(userId)) {

			return true;

		}
		return false;
	}

	
	@Override
	public void logout() {

	}

	@Override
	public void passwordReset(String secretAnswer) {

	}
}

package models.bookkeepingmodel;

import entities.bookkeeping.Account;

public interface IAccountModel {

    /**
     * this method creates an account if needed on the plarform
     *
     * @return returns the account that has been created
     */
    Account createAccount();

    /**
     * this method retrieves details of an account on the system
     *
     * @param accountId represents the accountId whose details is required
     * @return returns the details of the account after it has ben fetched from the db
     */
    Account getAccount(String accountId);

    /**
     * this method updates account informatoin in the sytem
     *
     * @return returns the the updated account
     */
    Account updateAccount();

    /**
     * this method deletes an account from the system
     *
     * @param accountId represents the id of the account to be deleted
     * @return returns true/false if the account succesfully deleted or not
     */
    boolean deleteAccount(String accountId);
}

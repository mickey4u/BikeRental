package dao.bookkeeping;

import entities.bookkeeping.Account;

public interface IAccount {

    /**
     * Retrieves the account from the database
     *
     * @param id of the Account to be loaded
     * @return returns the retrieved element
     */
    Account load(String id);

    /**
     * Creates the account in the db
     *
     * @param account details of the object to be created
     * @return
     */
    Account create(Account account);

    /**
     * This method deletes the account from the database
     *
     * @param id represents the id of the Account to be deleted
     * @return
     */
    boolean delete(String id);

    /**
     * Method checks if the account exists or not
     *
     * @param id
     * @return
     */
    boolean ensureExists(String id);
}

package dao.bookkeepingdao;

import entities.bookkeeping.Ledger;

public interface ILedgerDao {
    /**
     * Retrieves the account from the database
     *
     * @param id of the ledger to be loaded
     * @return returns the retrieved element
     */
    Ledger load(String id);

    /**
     * Creates the ledger in the db
     *
     * @param ledger details of the object to be created
     * @return
     */
    Ledger create(Ledger ledger);

    /**
     * This method deletes the ledger from the database
     *
     * @param id represents the id of the ledger to be deleted
     * @return
     */
    boolean delete(String id);

    /**
     * Method checks if the ledger exists or not
     *
     * @param id
     * @return
     */
    boolean ensureExists(String id);
}

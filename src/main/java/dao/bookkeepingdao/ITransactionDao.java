package dao.bookkeepingdao;

import entities.bookkeeping.Transaction;

public interface ITransactionDao {

    /**
     * Retrieves the transaction from the database
     *
     * @param id of the transaction to be loaded
     * @return returns the retrieved element
     */
    Transaction load(String id);

    /**
     * Creates the transaction in the db
     *
     * @param transaction details of the transaction to be created
     * @return
     */
    Transaction create(Transaction transaction);

    /**
     * This method deletes the transaction from the database
     *
     * @param id represents the id of the transaction to be deleted
     * @return
     */
    boolean delete(String id);

    /**
     * Method checks if the transaction exists or not
     *
     * @param id
     * @return
     */
    boolean ensureExists(String id);
}

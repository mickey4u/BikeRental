package dao.bookkeepingdao;

import entities.bookkeeping.Transaction;

public class TransactionDao implements ITransactionDao {

    @Override
    public Transaction load(String id) {
        return null;
    }

    @Override
    public Transaction create(Transaction transaction) {
        return null;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public boolean ensureExists(String id) {
        return false;
    }
}

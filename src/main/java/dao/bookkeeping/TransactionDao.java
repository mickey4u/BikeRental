package dao.bookkeeping;

import entities.bookkeeping.Transaction;

public class TransactionDao implements ITransaction{

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

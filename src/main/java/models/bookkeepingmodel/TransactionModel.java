package models.bookkeepingmodel;

import entities.bookkeeping.Transaction;

public class TransactionModel implements ITransactionModel{
    @Override
    public Transaction getTransaction() {
        return null;
    }

    @Override
    public boolean createTransaction(Transaction transaction) {
        return false;
    }
}

package models.bookkeepingmodel.interfaces;

import entities.bookkeeping.Transaction;

public interface ITransaction {

    Transaction getTransaction();
    boolean createTransaction(Transaction transaction);
}

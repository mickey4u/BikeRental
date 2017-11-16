package models.bookkeeping.interfaces;

import entities.bookkeeping.Transaction;

public interface ITransaction {

    Transaction getTransaction();
    boolean createTransaction(Transaction transaction);
}

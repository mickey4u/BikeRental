package models.bookkeepingmodel;

import entities.bookkeeping.Transaction;

public interface ITransactionModel {

    Transaction getTransaction();
    boolean createTransaction(Transaction transaction);
}

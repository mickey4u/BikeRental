package models.bookkeepingmodel;

import entities.bookkeeping.Ledger;

public interface ILedgerModel {

    Ledger getLedger(String ledgerId);

    Ledger createLedger(Ledger ledger);

    Ledger updateLedger(String ledgerId, Ledger ledger);

    boolean deletedLedger(String ledgerId);
}

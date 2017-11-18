package models.bookkeepingmodel.interfaces;

import entities.bookkeeping.Ledger;

public interface ILedger {

    Ledger getLedger(String ledgerId);

    Ledger createLedger(Ledger ledger);

    Ledger updateLedger(String ledgerId, Ledger ledger);

    boolean deletedLedger(String ledgerId);
}

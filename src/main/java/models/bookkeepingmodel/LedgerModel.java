package models.bookkeepingmodel;


import entities.bookkeeping.Ledger;

public class LedgerModel implements ILedgerModel{
    @Override
    public Ledger getLedger(String ledgerId) {
        return null;
    }

    @Override
    public Ledger createLedger(Ledger ledger) {
        return null;
    }

    @Override
    public Ledger updateLedger(String ledgerId, Ledger ledger) {
        return null;
    }

    @Override
    public boolean deletedLedger(String ledgerId) {
        return false;
    }
}

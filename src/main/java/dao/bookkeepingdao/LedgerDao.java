package dao.bookkeepingdao;

import entities.bookkeeping.Ledger;

public class LedgerDao implements ILedger {

    @Override
    public Ledger load(String id) {
        return null;
    }

    @Override
    public Ledger create(Ledger ledger) {
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

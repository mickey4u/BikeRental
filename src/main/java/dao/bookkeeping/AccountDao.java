package dao.bookkeeping;

import entities.bookkeeping.Account;

public class AccountDao implements IAccount{
    @Override
    public Account load(String id) {
        return null;
    }

    @Override
    public Account create(Account account) {
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

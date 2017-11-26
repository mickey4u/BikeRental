package dao.bookkeepingdao;

import entities.bookkeeping.Account;

public class AccountDao implements IAccountDao {
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

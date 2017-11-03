package entities.bookkeeping;

import org.javamoney.moneta.Money;

/**
 * account maintained by a user on the bike rental
 * platform
 */
public class Account {

    // balance on the account
    private Money balance;
    // limit on the account
    private Money limit;
    // id of the ledger the account is attached to
    private String ledgerId;

}

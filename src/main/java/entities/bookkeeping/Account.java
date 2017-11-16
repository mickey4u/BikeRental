package entities.bookkeeping;

import org.javamoney.moneta.Money;

import java.time.ZonedDateTime;

/**
 * account maintained by a user on the bike rental
 * platform
 */
public class Account {
    // account id
    private String id;
    // balance on the account
    private Money balance;
    // id of the ledger the account is attached to
    private String ledgerId;
    // time the account was created
    private ZonedDateTime created;
    // time the account was last modified
    private ZonedDateTime lastModified;
}

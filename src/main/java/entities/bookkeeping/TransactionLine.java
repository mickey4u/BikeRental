package entities.bookkeeping;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.javamoney.moneta.Money;

import java.time.ZonedDateTime;

/**
 * Represents a line within a transaction
 */
@Data
@AllArgsConstructor
public class TransactionLine {
    // id of the transaction
    private String lineId;
    // the account this line belongs to
    private String accountId;
    // represents the
    private String transactionId;
    // side of account affected by this entry
    private ValueType valueType;
    // time the transaction was created
    private ZonedDateTime created;
    // amount of money involved in this country
    private Money amount;
    // purpose of the transaction i.e refund, commission,
    String purpose;
}

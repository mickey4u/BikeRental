package entities.bookkeeping;

import lombok.Data;

import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Set;

/**
 * Represents a transaction batch. Made of transaction lines
 */
@Data
public class Transaction {
    // represents the transactionId
    private String id;
    // lines that makeup the transaction
    private Set<TransactionLine> transactionLines;
    // time the transaction was created
    private ZonedDateTime createdAt;

    public Transaction(Set<TransactionLine> transactionLines) {
        this.transactionLines = transactionLines;
    }

    /**
     * The method checks if the debit and credit side of the account balances out
     *
     * @return true if both side of the account balance otherwise false
     */
    public boolean isBalanced() {
        BigDecimal debits = transactionLines
                .stream()
                .map(transactionLine -> transactionLine.getValueType() == ValueType.DEBIT ?
                        transactionLine.getAmount().getNumber().numberValue(BigDecimal.class) :
                        transactionLine.getAmount().getNumber()
                                .numberValue(BigDecimal.class).negate())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return debits.compareTo(BigDecimal.ZERO) == 0;
    }
}

package entities.bookkeeping;

import java.util.HashSet;
import java.util.Set;

/**
 * Handles the construction of a transaction object
 */
public class TransactionBuilder {

    Set<TransactionLine> lineEntries;

    public TransactionBuilder() {
        lineEntries = new HashSet<>();
    }

    public static TransactionBuilder createTransaction() {
        return new TransactionBuilder();
    }

    public TransactionBuilder debit(TransactionLine tl) {
        tl.setValueType(ValueType.DEBIT);
        lineEntries.add(tl);
        return this;
    }

    public TransactionBuilder credit(TransactionLine tl) {
        tl.setValueType(ValueType.CREDIT);
        lineEntries.add(tl);
        return this;
    }

    public Transaction build() {
        return new Transaction(lineEntries);
    }

}

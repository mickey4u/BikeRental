package entities.bookkeeping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * Represents a transaction batch. Made of transaction lines
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Transaction {
    // represents the transactionId
    private String id;
    private List<TransactionLine> lines;
}

package entities.bookkeeping;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.javamoney.moneta.Money;

import java.util.List;

/**
 *
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Ledger {
    // id of the ledger
    private String id;
    // balance on the ledger
    List<Money> ledgerBalance;
}

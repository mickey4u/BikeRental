package dao.support;

import entities.support.Ticket;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class SupportDao implements ISupportDao {
    private final SupportAccess access;

    /**
     * Inserts Ticket into Database
     *
     * @param ticket
     * @return
     */
    @Override
    public boolean insertTicket(Ticket ticket) {
        Optional.ofNullable(ticket).orElseThrow(NullPointerException::new);
        return access.insertTicket(ticket);
    }
}

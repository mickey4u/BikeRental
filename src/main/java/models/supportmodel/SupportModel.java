package models.supportmodel;

import dao.support.ISupportDao;
import entities.support.Ticket;

public class SupportModel implements ISupportModel {
    private ISupportDao supportDao;

    public SupportModel(ISupportDao supportDao) {
        this.supportDao = supportDao;
    }

    /**
     * Logs a Ticket for the User
     *
     * @param ticket
     * @return
     */
    @Override
    public boolean raiseTicket(Ticket ticket) {

        return supportDao.insertTicket(ticket);
    }
}

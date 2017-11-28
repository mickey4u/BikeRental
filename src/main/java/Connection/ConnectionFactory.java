package Connection;

/*
*
*  The abstract connection factory interface
* */
public interface ConnectionFactory {

    /**
     * Gets DataBase Connection
     *
     * @param
     * @return
     */
    ConnectionManager getConnection();
}

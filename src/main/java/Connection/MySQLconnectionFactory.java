package Connection;

/*
* Concrete factory implementations for ConnectionFactory
* */
public class MySQLconnectionFactory implements ConnectionFactory {
    @Override
    public ConnectionManager getConnection() {
        return new MySqlConnection();
    }
}

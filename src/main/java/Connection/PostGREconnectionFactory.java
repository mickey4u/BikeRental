package Connection;

/*
* Concrete factory implementations for ConnectionFactory
* */
public class PostGREconnectionFactory implements ConnectionFactory {
    @Override
    public ConnectionManager getConnection() {
        return new PostGREconnection();
    }
}

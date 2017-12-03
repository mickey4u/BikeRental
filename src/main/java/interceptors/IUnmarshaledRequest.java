package interceptors;

/**
 * Context object
 */
public interface IUnmarshaledRequest<T> {

    void setObject(T object);

    T getObject();
}

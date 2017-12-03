package interceptors;

/**
 *
 */
public interface ClientRequestInterceptor {

    void onPreMarshalRequest(IUnmarshaledRequest context);

    void onPostMarshalRequest(MarshaledRequest context);
}

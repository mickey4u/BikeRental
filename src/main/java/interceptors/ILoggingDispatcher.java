package interceptors;

public interface ILoggingDispatcher {

    void dispatchClientPreRequestPreMarshal(IUnmarshaledRequest context);

    void register(ClientRequestInterceptor clientRequestInterceptor);

    void remove(ClientRequestInterceptor clientRequestInterceptor);
}

package interceptors;

import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class LoggingDispatcher implements ILoggingDispatcher {

    private List<ClientRequestInterceptor> clientRequestInterceptors = null;
    private final Object MUTEX = new Object();

    private LoggingDispatcher() {
        clientRequestInterceptors = new ArrayList<>();
    }

    public static LoggingDispatcher getInstance() {
        return SingletonHelper.instance;
    }

    private static class SingletonHelper {

        private static final LoggingDispatcher instance = new LoggingDispatcher();
    }

    @Override
    public void dispatchClientPreRequestPreMarshal(IUnmarshaledRequest context) {
        List<ClientRequestInterceptor> existingClientRequestInterceptors = null;
        synchronized (MUTEX) {
            // get all registered interceptors
            existingClientRequestInterceptors = new ArrayList<>(clientRequestInterceptors);
        }

        existingClientRequestInterceptors.stream().forEach(eld -> {
            // dispatch callback hook method
            eld.onPreMarshalRequest(context);
        });
    }

    @Override
    public void register(ClientRequestInterceptor clientRequestInterceptor) {
        synchronized (MUTEX) {
            boolean exists = clientRequestInterceptors
                    .stream()
                    .filter(cri -> clientRequestInterceptor.equals(cri))
                    .findFirst()
                    .isPresent();

            if (!exists) {
                clientRequestInterceptors.add(clientRequestInterceptor);
            }
        }
    }

    @Override
    public void remove(ClientRequestInterceptor clientRequestInterceptor) {
        synchronized (MUTEX) {
            boolean exists = clientRequestInterceptors
                    .stream()
                    .filter(cri -> clientRequestInterceptor.equals(cri))
                    .findFirst()
                    .isPresent();

            if (exists) {
                clientRequestInterceptors.remove(clientRequestInterceptor);
            }
        }
    }
}

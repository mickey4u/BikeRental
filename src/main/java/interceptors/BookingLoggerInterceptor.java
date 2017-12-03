package interceptors;

/**
 * Concrete interceptor for logging bike bookings
 */
public class BookingLoggerInterceptor implements ClientRequestInterceptor {

    @Override
    public void onPreMarshalRequest(IUnmarshaledRequest context) {
        System.err.println("------------->" + context.getObject().toString());
    }

    @Override
    public void onPostMarshalRequest(MarshaledRequest context) {

    }
}

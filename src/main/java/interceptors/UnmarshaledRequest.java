package interceptors;


public class UnmarshaledRequest implements IUnmarshaledRequest {

    private Object object;

    @Override
    public void setObject(Object object) {
        this.object = object;
    }

    @Override
    public Object getObject() {
        return this.object;
    }
}

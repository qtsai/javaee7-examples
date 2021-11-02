package nl.tsai.javaee.scope;

public class CounterPerScope {
    private final int application;
    private final int session;
    private final int request;

    public CounterPerScope(int application, int session, int request) {
        this.application = application;
        this.session = session;
        this.request = request;
    }

    public int getApplication() {
        return application;
    }

    public int getSession() {
        return session;
    }

    public int getRequest() {
        return request;
    }
}

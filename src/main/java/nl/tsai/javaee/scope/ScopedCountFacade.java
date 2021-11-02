package nl.tsai.javaee.scope;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic008.htm
 */
@Stateless
public class ScopedCountFacade {

    @Inject
    private ApplicationScopedCount applicationScopedCount;
    @Inject
    private SessionScopedCount sessionScopedCount;
    @Inject
    private RequestScopedCount requestScopedCount;

    public CounterPerScope count() {
        return new CounterPerScope(
                applicationScopedCount.count(),
                sessionScopedCount.count(),
                requestScopedCount.count()
        );
    }

}



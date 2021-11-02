package nl.tsai.javaee.scope;

import javax.enterprise.context.ApplicationScoped;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic008.htm
 */
@ApplicationScoped
public class ApplicationScopedCount {
    private int counter = 0;

    public int count() {
        return ++counter;
    }
}

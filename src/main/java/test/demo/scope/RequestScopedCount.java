package test.demo.scope;

import javax.enterprise.context.RequestScoped;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic008.htm
 */
@RequestScoped
public class RequestScopedCount {
    private int counter = 0;

    public int count() {
        return ++counter;
    }
}
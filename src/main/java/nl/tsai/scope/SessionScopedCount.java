package nl.tsai.scope;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic008.htm
 */
@SessionScoped
public class SessionScopedCount implements Serializable {
    private int counter = 0;

    public int count() {
        return ++counter;
    }
}

package test.demo.inject;

import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
public class GreetingsFacade {

    @Inject
    private Greeting formal;

    @Inject
    @Informal
    private Greeting informal;

    public String formal() {
        return formal.say();
    }

    public String informal() {
        return informal.say();
    }
}

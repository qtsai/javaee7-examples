package nl.tsai.javaee.inject;

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

    public String formal(String name) {
        return formal.say(name);
    }

    public String informal(String name) {
        return informal.say(name);
    }
}

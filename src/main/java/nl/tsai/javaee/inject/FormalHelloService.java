package nl.tsai.javaee.inject;

import javax.ejb.Stateless;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
public class FormalHelloService implements Greeting {

    @Override
    public String say(String name) {
        return String.format("Hello %s", name);
    }
}

package nl.tsai.javaee.inject.alternatives;

import nl.tsai.javaee.inject.Greeting;

import javax.ejb.Stateless;
import javax.enterprise.inject.Alternative;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-adv002.htm
 */
@Stateless
@Alternative
public class WhatsUpService implements Greeting {
    @Override
    public String say(String name) {
        return String.format("'sup %s", name);
    }
}

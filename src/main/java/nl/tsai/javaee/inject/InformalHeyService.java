package nl.tsai.javaee.inject;

import javax.ejb.Stateless;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
@Informal
public class InformalHeyService implements Greeting {
    @Override
    public String say(String name) {
        return String.format("Hey %s", name);
    }
}

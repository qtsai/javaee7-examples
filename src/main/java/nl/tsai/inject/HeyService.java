package nl.tsai.inject;

import javax.ejb.Stateless;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
@Informal
public class HeyService implements Greeting {
    @Override
    public String say() {
        return "Hey";
    }
}

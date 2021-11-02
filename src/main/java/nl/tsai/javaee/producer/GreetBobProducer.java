package nl.tsai.javaee.producer;

import javax.ejb.Stateless;
import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic006.htm
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic012.htm
 */
@Stateless
public class GreetBobProducer {

    @Produces
    @GreetBob
    public String greetBob() {
        return "Hi Bob" + new Random().nextInt();
    }
}

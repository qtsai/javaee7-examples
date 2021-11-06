package nl.tsai.javaee.producer;

import javax.ejb.Stateless;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic006.htm
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic012.htm

 * https://docs.oracle.com/javaee/7/tutorial/cdi-adv003.htm
 */
@Stateless
public class GreetBobProducer {

    @Produces
    @GreetBob
    public String greetBob() {
        return "Hi Bob" + new Random().nextInt();
    }

    public void close(@Disposes @GreetBob String greet) {
        System.out.println("Disposing "+ greet);
    }
}

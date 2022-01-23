package nl.tsai.javaee.decorator;

import nl.tsai.javaee.inject.Greeting;

import javax.annotation.Priority;
import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.enterprise.inject.Any;
import javax.inject.Inject;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-adv007.htm#GKHQF
 */
@Decorator
@Priority(0)
public class BigGuyDecorator implements Greeting {

    @Inject
    @Delegate
    @Any
    private Greeting greeting;

    @Override
    public String say(String name) {
        return greeting.say("Big " + name);
    }
}

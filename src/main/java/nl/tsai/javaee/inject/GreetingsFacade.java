package nl.tsai.javaee.inject;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
public class GreetingsFacade {

    public GreetingsFacade() {
        System.out.println(this.getClass().getSimpleName() + " constructor called");
    }

    @PostConstruct
    public void postConstruct() {
        /*
         * https://stackoverflow.com/questions/3406555/why-use-postconstruct
         */
        System.out.println(this.getClass().getSimpleName() + " postconstruct called");
    }

    @PreDestroy
    public void preDestroy() {
        System.out.println(this.getClass().getSimpleName() + " predestroy called");

    }

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

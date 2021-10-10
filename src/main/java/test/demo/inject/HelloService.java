package test.demo.inject;

import javax.ejb.Stateless;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic007.htm
 */
@Stateless
public class HelloService implements Greeting {

    @Override
    public String say() {
        return "Hello";
    }
}

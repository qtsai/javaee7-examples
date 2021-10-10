package test.demo.producer;

import javax.inject.Qualifier;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * https://docs.oracle.com/javaee/7/tutorial/cdi-basic006.htm
 */
@Qualifier
@Retention(RUNTIME)
@Target({FIELD, METHOD, TYPE, PARAMETER})
public @interface GreetBob {
}

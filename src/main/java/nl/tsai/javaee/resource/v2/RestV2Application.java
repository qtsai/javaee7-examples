package nl.tsai.javaee.resource.v2;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.Set;

/**
 * https://docs.oracle.com/javaee/7/tutorial/jaxrs002.htm
 *
 * overridden v2 with v2-overridden in web.xml
 *
 * {@link ApplicationPath} annotation is not needed when declared in web.xml
 *
 */
@ApplicationPath("/api/v2")
public class RestV2Application extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        return Collections.singleton(HelloV2Resource.class);
    }
}